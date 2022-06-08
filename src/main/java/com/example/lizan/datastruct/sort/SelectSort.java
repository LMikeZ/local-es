package com.example.lizan.datastruct.sort;

import java.util.Arrays;

/**
 * 选择
 *
 * @author lizan
 * @version $Id: SelectSort.java, v 0.1 2022年06月06日 16:04 lizan Exp $$
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {3, 9, 1, 10, 2};

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = 1 + i; j < arr.length; j++) {
                if (min > arr[j]){
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex != i){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}