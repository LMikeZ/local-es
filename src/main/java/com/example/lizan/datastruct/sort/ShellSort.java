package com.example.lizan.datastruct.sort;

import java.util.Arrays;

/**
 * 希尔
 *
 * @author lizan
 * @version $Id: ShellSort.java, v 0.1 2022年06月06日 16:34 lizan Exp $$
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        //交换法
//        shellSort(arr);
        //移位法
        shellSort2(arr);
    }

    private static void shellSort2(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void shellSort(int[] arr) {
        for (int i = arr.length / 3; i > 0; i /= 3) {
            for (int j = i; j < arr.length; j++) {
                for (int k = j - i; k >= 0; k -= i) {
                    if (arr[k] > arr[k + i]) {
                        int temp = arr[k];
                        arr[k] = arr[k + i];
                        arr[k + i] = temp;
                    }
                }
            }
        }

    }
}