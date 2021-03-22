package com.shravan.learn.algorithms.sort;

import com.shravan.learn.common.ArrayUtil;

import java.util.Arrays;

/**
 * Sort N elements in a range from 1 to N^2
 * The idea of Radix Sort is to do digit by digit sort starting from least significant digit
 * to most significant digit. Radix sort uses counting sort as a subroutine to sort.
 * T(n) = O(d*(n+b)), b is base for representing numbers, d is digits of maximum value k (d = logb k)
 * T(n) = O((n+b)*logb k) => O(n) to sort number from 1 to n^c if numbers are represent in base n, i.e. k<=n^c, b = n
 * S(n) = O(n+k)
 */
public class RadixSort {

    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    static void countSort(int[] arr, int n, int exp) {
        int[] output = new int[n]; // output array
        int i;
        int[] count = new int[10];
        Arrays.fill(count, 0);

        // Store count of occurrences in count[]
        for (i = 0; i < n; i++)
            count[nthPlace(arr[i], exp)]++;

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Build the output array
        for (i = n - 1; i >= 0; i--) {
            output[count[nthPlace(arr[i], exp)] - 1] = arr[i];
            count[nthPlace(arr[i], exp)]--;
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to curent digit
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }

    private static int nthPlace(int num, int exp) {
        return (num / exp) % 10;
    }

    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        int n = arr.length;
        RadixSort solution = new RadixSort();
        // Function Call
        solution.sort(arr, n);
        System.out.println("arr = " + Arrays.toString(arr));
    }

    // The main function to that sorts arr[] of size n using Radix Sort
    void sort(int[] arr, int n) {
        // Find the maximum number to know number of digits
        int m = ArrayUtil.max(arr);

        // Do counting sort for every digit. Note that
        // instead of passing digit number, exp is passed.
        // exp is 10^i where i is current digit number
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }
}
