package com.shravan.learn.algorithms.sort;

import com.shravan.learn.common.ArrayUtil;

import java.util.Arrays;

/**
 * Find smallest element index in unsorted array and swap with first element
 * T(n) = O(n^2)
 * S(n) = O(1)
 */
public class SelectionSort {
    public static void main(String[] args) {
        SelectionSort solution = new SelectionSort();
        int[] arr = {64, 25, 12, 22, 11};
        solution.sort(arr);
        System.out.println("arr = " + Arrays.toString(arr));
    }

    public void sort(int[] arr) {
        int n = arr.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element index in unsorted array
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            // Swap the found minimum element with the first element
            ArrayUtil.swap(arr, i, min_idx);
        }
    }
}
