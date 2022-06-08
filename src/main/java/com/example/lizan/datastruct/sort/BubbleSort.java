package com.example.lizan.datastruct.sort;

import java.util.Arrays;

/**
 * 冒泡
 * @author lizan
 * @version $Id: BubbleSort.java, v 0.1 2022年06月06日 15:44 lizan Exp $$
 */
public class BubbleSort {
    public static void main(String[] args) {
//        int[] arr = {3, 9, 1, 10, 2};
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 80000);
        }
        long start = System.currentTimeMillis();
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
//        System.out.println(Arrays.toString(arr));
    }
}