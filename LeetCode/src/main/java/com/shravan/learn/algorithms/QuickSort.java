package com.shravan.learn.algorithms;

import com.shravan.learn.common.ArrayUtil;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        QuickSort solution = new QuickSort();
        int[] nums = {1, 10, 2, 9, 3, 8, 4, 7, 5, 6,};
        solution.quickSort(nums);
        System.out.println("nums = " + Arrays.toString(nums));
    }

    public void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int pivot = partition(nums, left, right, right);
        quickSort(nums, left, pivot - 1);
        quickSort(nums, pivot + 1, right);
    }

    private int partition(int[] nums, int left, int right, int pivotIndex) {
        ArrayUtil.swap(nums, right, pivotIndex);
        int storeIndex = left;
        for (int i = left; i <= right; i++) {
            if (nums[i] < nums[pivotIndex]) {
                ArrayUtil.swap(nums, storeIndex, i);
                storeIndex++;
            }
        }
        ArrayUtil.swap(nums, storeIndex, right);
        return storeIndex;
    }
}
