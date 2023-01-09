package com.example.lizan.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lizan
 * @version $Id: ReetranLockDemo.java, v 0.1 2023年01月04日 17:56 lizan Exp $$
 */
public class ReentrantLockDemo {

    public static void demo(){

        ReentrantLock reentrantLock = new ReentrantLock(true);
        try {
            reentrantLock.lock();
            System.out.println("-----------");

        }catch (Exception e){

        }finally {
            reentrantLock.unlock();
        }
    }
    public static void main(String[] args) {

    }
}
