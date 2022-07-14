package com.example.lizan.proxy.cglibproxy;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author lizan
 * @version $Id: CglibProxyFactory.java, v 0.1 2022年06月13日 16:11 lizan Exp $$
 */
public class CglibProxyFactory {
    public static Object getProxy(Class<?> clazz) {
        // 创建动态代理增强类
        Enhancer enhancer = new Enhancer();
        // 设置类加载器
        enhancer.setClassLoader(clazz.getClassLoader());
        // 设置被代理类
        enhancer.setSuperclass(clazz);
        // 设置方法拦截器
        enhancer.setCallback(new DebugMethodInterceptor());
        // 创建代理类
        return enhancer.create();

    }
}