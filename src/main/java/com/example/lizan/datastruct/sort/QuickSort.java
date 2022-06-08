package com.example.lizan.datastruct.sort;

import java.util.Arrays;

/**
 * @author lizan
 * @version $Id: QuickSort.java, v 0.1 2022年06月07日 14:38 lizan Exp $$
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {3, 9, 1, 4, 10, 2};
        quickSort(arr, 0, arr.length - 1);
//        quickSort2(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort2(int[] arr, int left, int right) {
        if (left>=right){return;}
        int l = left;
        int r = right;
        int mid = arr[left];
        while (l < r) {
            while (l < r && arr[r] > mid) {
                r -= 1;
            }
            arr[l] = arr[r];
            while (l < r && arr[l] < mid) {
                l += 1;
            }
            arr[r] = arr[l];
        }
        arr[left] = mid;
        quickSort2(arr, left, l - 1);
        quickSort2(arr, r + 1, right);
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left>=right){return;}

        int l = left;
        int r = right;
        int temp = 0;
        int mid = arr[(left + right) / 2];
        while (l < r) {
            while (arr[l] < mid) {
                l += 1;
            }
            while (arr[r] > mid) {
                r -= 1;
            }
            if (l >= r) {
                break;
            }
            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            if (arr[l] == mid) {
                r -= 1;
            }
            if (arr[r] == mid) {
                l += 1;
            }
        }

        if (l == r) {
            l += 1;
            r -= 1;
        }
        if (left < r) {
            quickSort(arr, left, r);
        }
        if (l < right) {
            quickSort(arr, l, right);

        }

    }


}