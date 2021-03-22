package com.shravan.learn.algorithms.sort;

import com.shravan.learn.common.ArrayUtil;

import java.util.Arrays;

/**
 * Swap consecutive elements if they are not in order
 * T(n) = O(n^2), Best case T(n) = O(n) when element are already in sorted order
 * S(n) = O(1)
 */
public class BubbleSort {
    public static void main(String[] args) {
        BubbleSort solution = new BubbleSort();
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        solution.bubbleSort(arr);
        System.out.println("arr = " + Arrays.toString(arr));
    }

    public void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap j and j+1
                    ArrayUtil.swap(arr, j, j + 1);
                }
            }
        }
    }
}
