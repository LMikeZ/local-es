package com.example.lizan.lock;

/**
 * @author lizan
 * @version $Id: SynchronizedDemo.java, v 0.1 2023年01月04日 17:57 lizan Exp $$
 */
public class SynchronizedDemo {
    Object object = new Object();
    public void method1() {
        synchronized (object) {

        }
        method2();
    }

    private static void method2() {

    }
}
