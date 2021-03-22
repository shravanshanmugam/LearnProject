package com.shravan.learn.algorithms.sort;

import com.shravan.learn.common.ArrayUtil;

import java.util.Arrays;

/**
 * An array ‘arr[0..n-1]’ is sorted in wave form if arr[0] >= arr[1] <= arr[2] >= arr[3] <= arr[4] >= …..
 * Even index elements should be greater than adjacent odd index elements
 * T(n) = O(n)
 * S(n) = O(1)
 */
public class WaveSort {
    public static void main(String[] args) {
        WaveSort solution = new WaveSort();
        int[] arr = {10, 90, 49, 2, 1, 5, 23};
        int n = arr.length;
        solution.sort(arr, n);
        System.out.println("arr = " + Arrays.toString(arr));
    }

    void sort(int[] arr, int n) {
        // Traverse all even elements
        for (int i = 0; i < n; i += 2) {
            // If current even element is smaller than previous
            if (i > 0 && arr[i - 1] > arr[i])
                ArrayUtil.swap(arr, i - 1, i);

            // If current even element is smaller than next
            if (i < n - 1 && arr[i] < arr[i + 1])
                ArrayUtil.swap(arr, i, i + 1);
        }
    }
}
