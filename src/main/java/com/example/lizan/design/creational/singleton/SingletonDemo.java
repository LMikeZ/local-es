package com.example.lizan.design.creational.singleton;

/**
 * 双重校验   适用于高并发的校验数据不存在保存
 * @author lizan
 * @version $Id: Singleton.java, v 0.1 2023年01月05日 11:07 lizan Exp $$
 */
public class SingletonDemo {
    public static volatile SingletonDemo singletonDemo;

    /**
     * 构造函数私有，禁止外部实例化
     */
    private SingletonDemo() {
    }

    public static SingletonDemo getInstance() {
        if (singletonDemo == null) {
            synchronized (SingletonDemo.class) {
                if (singletonDemo == null) {
                    singletonDemo = new SingletonDemo();
                }
            }
        }
        return singletonDemo;
    }
}
