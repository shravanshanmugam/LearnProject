package com.shravan.learn.problems.easy.sortandsearch;

public class Merge2SortedArrays {
    // a.length = m + n
    // merge into array a
    public void merge(int[] a, int m, int[] b, int n) {
        if (n == 0) return;

        int i = m - 1;
        int j = n - 1;
        int k = (m + n - 1);
        // iterate from last to first
        while (i >= 0 && j >= 0) {
            // greater element goes at the end
            if (a[i] > b[j]) a[k--] = a[i--];
            else a[k--] = b[j--];
        }

        // remaining elements of array b are inserted into array a
        while (j >= 0) a[k--] = b[j--];
    }
}
