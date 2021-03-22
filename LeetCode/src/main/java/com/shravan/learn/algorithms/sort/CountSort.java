package com.shravan.learn.algorithms.sort;

import java.util.Arrays;

/**
 * Sort N elements in a range from 1 to k
 * Count frequency of each element. Find cumulative frequency.
 * Each count indicates position of element
 * T(n) = O(n+k)
 * S(n) = O(n+k)
 */
public class CountSort {
    public static void main(String[] args) {
        CountSort solution = new CountSort();
        char[] arr = {'g', 'e', 'e', 'k', 's', 'f', 'o', 'r', 'g', 'e', 'e', 'k', 's'};
        solution.sort(arr);
        System.out.println("arr = " + Arrays.toString(arr));
    }

    void sort(char[] arr) {
        int n = arr.length;

        // The output character array that will have sorted arr
        char[] output = new char[n];

        // Create a count array to store count of individual
        // characters and initialize count array as 0
        int[] count = new int[26];

        // store count of each character
        for (int i = 0; i < n; ++i)
            ++count[arr[i] - 'a'];

        // Change count[i] so that count[i] now contains actual
        // position of this character in output array
        for (int i = 1; i <= 25; ++i)
            count[i] += count[i - 1];

        // Build the output character array
        // To make it stable we are operating in reverse order.
        System.out.println("count = " + Arrays.toString(count));
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i] - 'a'] - 1] = arr[i];
            --count[arr[i] - 'a'];
        }

        // Copy the output array to arr, so that arr now
        // contains sorted characters
        for (int i = 0; i < n; ++i)
            arr[i] = output[i];
    }
}
