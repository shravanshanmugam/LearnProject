package com.shravan.learn.algorithms.sort;

import java.util.Arrays;

/**
 * For each element find correct index position and insert
 * T(n) = O(n^2), Best case = O(n) when already elements are already in sorted order
 * S(n) = O(1)
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6};
        InsertionSort solution = new InsertionSort();
        solution.sort(arr);
        System.out.println("arr = " + Arrays.toString(arr));
    }

    void sort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
}
