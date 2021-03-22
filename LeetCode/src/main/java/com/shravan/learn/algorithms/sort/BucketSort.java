package com.shravan.learn.algorithms.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;

/**
 * Bucket sort, or bin sort, is a sorting algorithm that works by distributing the elements of an array into a number of buckets.
 * Find bucket index for each element, insert into the bucket.
 * Sort each bucket individually.
 * Combine all buckets
 * T(n) = O(n+k), Worst case T(n) = O(n^2) when all element fall into single bucket
 * S(n) = O(nk)
 */
public class BucketSort {
    public static void main(String[] args) {
        float[] arr = {0.897f, 0.565f, 0.656f, 0.1234f, 0.665f, 0.3434f};

        int n = arr.length;
        BucketSort solution = new BucketSort();
        solution.sort(arr, n);

        System.out.println("arr = " + Arrays.toString(arr));
    }

    public void sort(float[] arr, int n) {
        if (n <= 0)
            return;

        // 1) Create n empty buckets
        @SuppressWarnings("unchecked")
        Vector<Float>[] buckets = new Vector[n];

        for (int i = 0; i < n; i++) {
            buckets[i] = new Vector<>();
        }

        // 2) Put array elements in different buckets
        for (int i = 0; i < n; i++) {
            float idx = arr[i] * n;
            buckets[(int) idx].add(arr[i]);
        }

        // 3) Sort individual buckets
        for (int i = 0; i < n; i++) {
            Collections.sort(buckets[i]);
        }

        // 4) Concatenate all buckets into arr[]
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                arr[index++] = buckets[i].get(j);
            }
        }
    }
}
