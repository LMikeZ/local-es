package com.example.lizan.design;

/**
 * @author lizan
 * @version $Id: Singleton.java, v 0.1 2023年01月05日 11:07 lizan Exp $$
 */
public class Singleton {
    public static volatile Singleton singleton;

    /**
     * 构造函数私有，禁止外部实例化
     */
    private Singleton() {
    }

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
