package com.shravan.learn.algorithms;

import com.shravan.learn.common.ArrayUtil;

import java.util.Arrays;

public class QuickSelect {

    public static void main(String[] args) {
        QuickSelect solution = new QuickSelect();
        int[] nums = {1, 8, 2, 5, 4, 9, 10, 3, 6, 7};
        for (int k = 1; k <= nums.length; k++) {
            int[] largestKElements = solution.largestKElements(nums, k);
            System.out.println("largest " + k + " Elements = " + Arrays.toString(largestKElements));
        }
    }

    public int[] largestKElements(int[] nums, int k) {
        if (nums.length == k) return nums;
        int n = nums.length;
        quickSelect(nums, 0, n - 1, n - k);
        return Arrays.copyOfRange(nums, n - k, n);
    }

    private void quickSelect(int[] nums, int left, int right, int k_smallest) {
        if (left == right) return;
        int pivotIndex = partition(nums, left, right, right);
        if (pivotIndex == k_smallest) {
            return;
        } else if (k_smallest < pivotIndex) {
            // go left - we need more elements
            quickSelect(nums, left, pivotIndex - 1, k_smallest);
        } else {
            // go right - we need less elements
            quickSelect(nums, pivotIndex + 1, right, k_smallest);
        }

    }

    // Lomuto's Partition Scheme
    // move elements less than pivotFrequency to left and greater than pivot value to right
    // return index where pivot is placed
    private int partition(int[] nums, int left, int right, int pivotIndex) {
        ArrayUtil.swap(nums, pivotIndex, right);
        int store_index = left;
        for (int i = left; i <= right; i++) {
            if (nums[i] < nums[pivotIndex]) {
                ArrayUtil.swap(nums, store_index, i);
                store_index++;
            }
        }
        ArrayUtil.swap(nums, store_index, right);
        return store_index;
    }
}
