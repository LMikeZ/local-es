package com.example.lizan.eventBus.handler;

import com.example.lizan.eventBus.IMessage;
import com.example.lizan.eventBus.MessageHeader;
import com.example.lizan.eventBus.MsgContext;
import com.example.lizan.eventBus.anno.MessageTag;
import com.example.lizan.eventBus.anno.OnEvent;
import com.example.lizan.eventBus.anno.Schedule;
import com.example.lizan.eventBus.anno.Subscriber;
import com.example.lizan.eventBus.exception.EventExceptionWrapper;
import com.example.lizan.eventBus.mo.BeanMethod;
import com.example.lizan.eventBus.mo.ExceptionHandlerInfo;
import com.example.lizan.eventBus.mo.InterceptorAttr;
import com.example.lizan.eventBus.mo.SubscriberInfo;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.util.Assert;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Proxy;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

/**
 * @author zhaocheng
 * @version 1.0.0
 * @createDate 2020-07-24 16:43
 * @Description TODO
 */
@Slf4j
public class DispatchHandler implements ApplicationContextAware {

    private final ExecutorService workThread = new ThreadPoolExecutor(4, 8,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(Integer.MAX_VALUE), new CustomThreadFactory("EventMsgPollDispatch-"));

    private final ExecutorService cacheThread = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
            60L, TimeUnit.SECONDS,
            new SynchronousQueue<>(), new CustomThreadFactory("EventMsgCacheDispatch-"));


    private final ExecutorService single = new ThreadPoolExecutor(1, 1,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(), new CustomThreadFactory("EventMsgSingleDispatch-"));
    private ApplicationContext applicationContext;
    private com.example.lizan.eventBus.handler.InterceptorHandler interceptorHandler;
    private Map<String, BeanMethod> eventNameRegister = new HashMap<>();
    private Map<Class, List<SubscriberInfo>> subscriber = new HashMap<>();
    private Map<Class, List<ExceptionHandlerInfo>> throwableListMap = new HashMap<>();


    final int MAX_ENTRIES = 1024;
    Map<Class, List<SubscriberInfo>> cache = Collections.synchronizedMap(new LinkedHashMap<Class, List<SubscriberInfo>>(MAX_ENTRIES + 1, .75F, true) {
        public boolean removeEldestEntry(Map.Entry eldest) {
            return size() > MAX_ENTRIES;
        }
    });


    public static final class CustomThreadFactory implements ThreadFactory {
        private final ThreadGroup group;
        private final String namePrefix;
        private final AtomicInteger index = new AtomicInteger(1);

        public CustomThreadFactory(String namePrefix) {
            this.namePrefix = namePrefix;
            group = Thread.currentThread().getThreadGroup();
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(group, r, namePrefix
                    + index.getAndIncrement());
            t.setDaemon(false);
            if (t.getPriority() != Thread.NORM_PRIORITY) {
                t.setPriority(Thread.NORM_PRIORITY);
            }
            return t;
        }
    }

    public DispatchHandler(InterceptorHandler interceptorHandler) {
        this.interceptorHandler = interceptorHandler;
    }

    public boolean hasEventSubscriber(String name) {
        return eventNameRegister.containsKey(name);
    }


    public void addEventMethod(String eventName, String beanName, Method method) {
        BeanMethod beanMethods = eventNameRegister.get(eventName);
        if (beanMethods != null) {
            throw new RuntimeException(String.format("onEvent is duplicate class %s  method %s", beanName, method.getName()));
        }
        eventNameRegister.put(eventName, getBeanMethod(eventName, beanName, method));
    }

    private BeanMethod getBeanMethod(String eventName, String beanName, Method method) {
        log.debug("addEventMethod eventName:{} , beanName:{} , method:{}", eventName, beanName, method.getName());

        int heardIndex = -1;
        int valueIndex = -1;

        Parameter[] parameters = method.getParameters();
        Assert.isTrue(!(parameters.length > 2), "process args error " + method.getName());
        String[] argNames = new String[parameters.length];
        for (int i = 0; i < parameters.length; i++) {
            Class<?> parameterType = parameters[i].getType();
            if (parameterType.equals(MessageHeader.class)) {
                heardIndex = i;
            } else if (IMessage.class.isAssignableFrom(parameterType)) {
                valueIndex = i;
            } else {
                throw new RuntimeException("not dispatch args type " + parameterType);
            }
            argNames[i] = parameters[i].getName();
        }


        return new BeanMethod(beanName, method, heardIndex, valueIndex, method.getParameterTypes().length, argNames);
    }


    public void dispatchEvent(IMessage message) throws EventExceptionWrapper {

        MessageTag annotation = message.getClass().getAnnotation(MessageTag.class);
        String s = annotation.value();
        BeanMethod beanMethod = eventNameRegister.get(s);
        if (beanMethod != null) {
            Object bean = applicationContext.getBean(beanMethod.getBeanName());
            OnEvent onEvent = beanMethod.getMethod().getAnnotation(OnEvent.class);
            Schedule schedule = onEvent.schedule();
            MessageHeader header = MsgContext.get().getHeader();
            try {
                chooseThreadPatch(schedule, () -> invokeMethod(message, beanMethod, bean, header));
            } catch (InvocationTargetException e) {
                throw new EventExceptionWrapper(message, e.getTargetException(), header);
            } catch (Throwable t) {
                throw new EventExceptionWrapper(message, t, header);
            } finally {
                MsgContext.get().destroy();
            }
        }
    }


    private void chooseThreadPatch(Schedule schedule, Callable<Boolean> runnable) throws Exception {
        switch (schedule) {
            case MAIN:
                runnable.call();
                break;
            case NEW:
                cacheThread.submit(runnable);
            case WORK:
                workThread.submit(runnable);
                break;
            case SINGLE:
                single.submit(runnable);
                break;
        }


    }

    private boolean invokeMethod(IMessage message, BeanMethod beanMethod, Object bean, MessageHeader header) throws IllegalAccessException, InvocationTargetException {

        Method method = beanMethod.getMethod();
        Object[] args = new Object[beanMethod.getArgSize()];
        if (beanMethod.getHeardIndex() != -1) {
            args[beanMethod.getHeardIndex()] = header;
        }

        if (beanMethod.getValueIndex() != -1) {
            args[beanMethod.getValueIndex()] = message;
        }
        InterceptorAttr interceptorAttr = null;

        if (interceptorHandler.hasInterceptors()) {
            interceptorAttr = InterceptorAttr.builder()
                    .args(args)
                    .bean(bean)
                    .message(message)
                    .method(method)
                    .header(header)
                    .argsName(beanMethod.getArgsName()).build();
        }

        if (!interceptorHandler.disPatchStart(interceptorAttr)) {
            return false;
        }
        method.invoke(bean, args);
        return interceptorHandler.disPatchEnd(interceptorAttr);

    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }


    public void addSubscriber(String beanName, Method method, Class<?> parameterType) {
        log.debug("addSubscriber {} {} {}", beanName, method.getName(), parameterType);
        List<SubscriberInfo> subscriberInfos = subscriber.computeIfAbsent(parameterType, v -> new ArrayList<>());
        Subscriber annotation = method.getAnnotation(Subscriber.class);
        subscriberInfos.add(new SubscriberInfo(beanName, method, annotation));
    }


    public void dispatchSubscriber(Object object) {
        List<SubscriberInfo> subscriberInfos = findSubscriberByObject(object);

        interceptorHandler.disPatchSubscriberStart(object);
        if (!CollectionUtils.isEmpty(subscriberInfos)) {
            for (SubscriberInfo subscriberInfo : subscriberInfos) {
                try {
                    chooseThreadPatch(subscriberInfo.getSubscriber().schedule(), () -> {
                        String beanName = subscriberInfo.getBeanName();
                        Object bean = applicationContext.getBean(beanName);
                        interceptorHandler.disPatchProcessItem(bean.getClass(), subscriberInfo.getMethod(), object);
                        subscriberInfo.getMethod().invoke(bean, object);
                        return true;
                    });
                } catch (Throwable e) {
                    log.error("dispatchSubscriber error {}", object.getClass(), e);
                }
            }
        }
        interceptorHandler.disPatchSubscriberEnd(object);
    }

    private List<SubscriberInfo> findSubscriberByObject(Object object) {
        Class<?> clz = object.getClass();
        return cache.computeIfAbsent(clz, aClass -> {
            List<SubscriberInfo> subscriberInfos = new ArrayList<>();
            for (Map.Entry<Class, List<SubscriberInfo>> classListEntry : subscriber.entrySet()) {
                if (classListEntry.getKey() == clz) {
                    subscriberInfos.addAll(classListEntry.getValue());
                } else if (classListEntry.getKey().isAssignableFrom(clz)) {
                    List<SubscriberInfo> collect = classListEntry.getValue().stream().filter(subscriberInfo -> {
//                        boolean b = subscriberInfo.getSubscriber().receiveAssignableFromClz();
//                        if (!b) return false;
                        Subscriber infoSubscriber = subscriberInfo.getSubscriber();
                        if (infoSubscriber.receiveAssignableFromClz()) {
                            return true;
                        } else if (infoSubscriber.receiveProxyClz() && Proxy.isProxyClass(clz)) {
                            return true;
                        }
                        return false;

                    }).collect(Collectors.toList());
                    subscriberInfos.addAll(collect);
                }
            }
            ;
            return subscriberInfos;
        });

    }

    public void dispatchEventException(EventExceptionWrapper e) throws Throwable {
        Throwable target = e.getTarget();
        List<ExceptionHandlerInfo> exceptionHandlerInfos = throwableListMap.get(target.getClass());
        if (exceptionHandlerInfos != null) {
            for (ExceptionHandlerInfo exceptionHandlerInfo : exceptionHandlerInfos) {
                Object[] args = new Object[exceptionHandlerInfo.getMethod().getParameters().length];
                if (exceptionHandlerInfo.getExceptionIndex() != -1) {
                    args[exceptionHandlerInfo.getExceptionIndex()] = e.getTarget();
                }
                if (exceptionHandlerInfo.getIMsgIndex() != -1) {
                    args[exceptionHandlerInfo.getIMsgIndex()] = e.getTargetMessage();
                }
                if (exceptionHandlerInfo.getIHeadIndex() != -1) {
                    args[exceptionHandlerInfo.getIHeadIndex()] = e.getMessageHeader();
                }
                Object bean = applicationContext.getBean(exceptionHandlerInfo.getBeanName());
                exceptionHandlerInfo.getMethod().invoke(bean, args);
            }
        } else {
            throw target;
        }
    }

    public void addExceptionHandler(String beanName, Method method, Class<? extends Throwable>[] value) {

        for (Class<? extends Throwable> aClass : value) {
            List<ExceptionHandlerInfo> exceptionHandlerInfos = throwableListMap.computeIfAbsent(aClass, aClass1 -> new ArrayList<>());
            ExceptionHandlerInfo.ExceptionHandlerInfoBuilder builder = ExceptionHandlerInfo.builder().beanName(beanName).method(method);
            Parameter[] parameters = method.getParameters();
            for (int i = 0; i < parameters.length; i++) {
                Parameter parameter = parameters[i];
                Class<?> type = parameter.getType();
                if (IMessage.class.isAssignableFrom(type)) {
                    builder.iMsgIndex(i);
                } else if (MessageHeader.class.isAssignableFrom(type)) {
                    builder.iHeadIndex(i);
                } else if (Throwable.class.isAssignableFrom(type)) {
                    builder.exceptionIndex(i);
                } else {
                    throw new RuntimeException(String.format("%s type not defind", type));
                }
            }
            exceptionHandlerInfos.add(builder.build());
        }
    }
}
