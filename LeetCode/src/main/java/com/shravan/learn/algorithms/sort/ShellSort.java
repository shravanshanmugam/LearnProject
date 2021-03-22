package com.shravan.learn.algorithms.sort;

import java.util.Arrays;

/**
 * The idea of shellSort is to allow exchange of far items.
 * In shellSort, we make the array h-sorted for a large value of h. We keep reducing the value of h until it becomes 1.
 * An array is said to be h-sorted if all sublists of every h’th element is sorted.
 * T(n) = O(n log n log n), Best case T(n) = O(n log n) when elements are already in sorted order, Worst case = O(n^2)
 * S(n) = O(1)
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {12, 34, 54, 2, 3};

        ShellSort solution = new ShellSort();
        solution.sort(arr);

        System.out.println("arr = " + Arrays.toString(arr));
    }

    int sort(int[] arr) {
        int n = arr.length;

        // Start with a big gap, then reduce the gap
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // Do a gapped insertion sort for this gap size.
            // The first gap elements a[0..gap-1] are already
            // in gapped order keep adding one more element
            // until the entire array is gap sorted
            for (int i = gap; i < n; i += 1) {
                // add a[i] to the elements that have been gap
                // sorted save a[i] in temp and make a hole at
                // position i
                int temp = arr[i];

                // shift earlier gap-sorted elements up until
                // the correct location for a[i] is found
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
                    arr[j] = arr[j - gap];

                // put temp (the original a[i]) in its correct
                // location
                arr[j] = temp;
            }
        }
        return 0;
    }
}
