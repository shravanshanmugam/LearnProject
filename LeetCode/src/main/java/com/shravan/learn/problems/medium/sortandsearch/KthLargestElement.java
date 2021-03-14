package com.shravan.learn.problems.medium.sortandsearch;

import java.util.Arrays;

public class KthLargestElement {
    public static void main(String[] args) {
        KthLargestElement solution = new KthLargestElement();
        int kthLargest = solution.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
        System.out.println("kthLargest = " + kthLargest);
        int kthLargest1 = solution.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4);
        System.out.println("kthLargest1 = " + kthLargest1);
    }

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
