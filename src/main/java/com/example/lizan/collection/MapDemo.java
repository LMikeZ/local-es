package com.example.lizan.collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lizan
 * @version $Id: MapDemo.java, v 0.1 2022年06月13日 16:49 lizan Exp $$
 */
public class MapDemo {
    private static final int MAXIMUM_CAPACITY = 1 << 30;

    public static void main(String[] args) {
        Hashtable<Object, Object> hashtable = new Hashtable<>();
        HashMap<Object, Object> hashMap = new HashMap<>(3);
        ConcurrentHashMap<Object, Object> objectConcurrentHashMap = new ConcurrentHashMap<>();
        objectConcurrentHashMap.put(1,1);
        hashMap.put(1,1);
        ConcurrentHashMap<Object, Object> concurrentHashMap = new ConcurrentHashMap<>();
//        concurrentHashMap.put()
        System.out.println(1 << 30);

        int n = 3 - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        int i = (0 > n) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
        System.out.println(i);


        HashSet<Object> hashSet = new HashSet<>();
//        hashSet.add()
    }
}