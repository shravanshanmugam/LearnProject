package com.shravan.learn.algorithms.sort;

import java.util.Arrays;

/**
 * It is based on Divide and Conquer algorithm. It divides the input array into two halves,
 * calls itself for the two halves, and then merges the two sorted halves.
 * T(n) = O(n log n)
 * S(n) = O(n)
 */
public class MergeSort {

    public static void main(String[] args) {
        MergeSort solution = new MergeSort();
        int[] arr = {12, 11, 13, 5, 6, 7};
        solution.sort(arr);
        System.out.println("arr = " + Arrays.toString(arr));
    }

    public void sort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    private void mergeSort(int[] nums, int start, int end) {
        if (start == end)
            return;
        int mid = (start + end) / 2;
        mergeSort(nums, 0, mid);
        mergeSort(nums, mid + 1, end);
        merge(nums, start, end);
    }

    private void merge(int[] nums, int start, int end) {
        int mid = (start + end) / 2;
        int i = start;
        int j = mid + 1;
        int k = start;
        int[] temp = new int[end - start + 1];
        while (i <= mid && j < end) {
            if (nums[i] < nums[j])
                temp[k++] = nums[i++];
            else
                temp[k++] = nums[j++];
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= end) {
            temp[k++] = nums[j++];
        }
        for (i = start; i <= end; i++)
            nums[i] = temp[i];
    }
}
