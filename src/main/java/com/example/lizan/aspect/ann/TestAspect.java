package com.example.lizan.aspect.ann;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @author lizan
 * @version $Id: TestAspect.java, v 0.1 2022年10月18日 17:54 lizan Exp $$
 */
@Component
@Aspect
public class TestAspect {
    //拦截所有被注解AuthCheck标注的方法
    @Pointcut("@annotation(com.example.lizan.aspect.ann.TestAuthAnn)")
    private void pointAll() {
    }

    /**
     * 环绕增强，验证权限
     *
     * @param joinPoint 目标对象
     * @param authCheck 自定义的注解，Around必须这样写，否则自定义的注解无法传入
     */
    @Around("pointAll() && @annotation(authCheck)")
    public Object before(ProceedingJoinPoint joinPoint, TestAuthAnn authCheck) throws Throwable {
        //先拿到Request请求体
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        System.out.println("此次请求的路径：" + request.getRequestURL());
        System.out.println("此次业务操作的权限ID：" + JSON.toJSONString(authCheck));
        //3、获取注解权限属性
        Object target = joinPoint.getTarget();
        Class<?> aClass = joinPoint.getTarget().getClass();
        //获取方法签名（通过此签名获得目标方法信息）
        MethodSignature ms = (MethodSignature)joinPoint.getSignature();
        Method method = aClass.getDeclaredMethod(ms.getName(),ms.getParameterTypes());
        TestAuthAnn annotation = method.getAnnotation(TestAuthAnn.class);
        return joinPoint.proceed();
    }
}