package com.shravan.learn.algorithms.sort;

import com.shravan.learn.common.ArrayUtil;

import java.util.Arrays;

/**
 * Dutch national flag sort problem
 * Sort an unsorted array of 0, 1 and 2s
 * Use 3 indices low, mid, and high. We have 4 sections
 * 1-low containing 0s
 * low-mid containing 1s
 * mid-high containing unknowns
 * high-N containing 2s
 * T(n) = O(n)
 * S(n) = O(1)
 */
public class DNFSort {
    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        int arr_size = arr.length;
        DNFSort solution = new DNFSort();
        solution.sort(arr, arr_size);
        System.out.println("arr = " + Arrays.toString(arr));
    }

    void sort(int[] arr, int arr_size) {
        int low = 0;
        int high = arr_size - 1;
        int mid = 0, temp = 0;
        while (mid <= high) {
            switch (arr[mid]) {
                case 0: {
                    ArrayUtil.swap(arr, low, mid);
                    low++;
                    mid++;
                    break;
                }
                case 1:
                    mid++;
                    break;
                case 2: {
                    ArrayUtil.swap(arr, mid, high);
                    high--;
                    break;
                }
            }
        }
    }
}
