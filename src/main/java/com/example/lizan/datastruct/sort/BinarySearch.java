package com.example.lizan.datastruct.sort;

/**
 * 二分查找发
 *
 * @author lizan
 * @version $Id: BinarySearch.java, v 0.1 2022年06月07日 19:18 lizan Exp $$
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};

        int findVal = 1;
        binarySerch(arr, 0, arr.length - 1, findVal);
    }

    private static void binarySerch(int[] arr, int left, int right, int findVal) {
        if (left > right) {
            return;
        }
        int mid = arr[(left + right) / 2];
        int index = (left + right) / 2;

        if (findVal > mid) {
            binarySerch(arr, index + 1, right, findVal);
        } else if (findVal < mid) {
            binarySerch(arr, left, index - 1, findVal);
        } else {
            System.out.println(index);
        }
    }
}