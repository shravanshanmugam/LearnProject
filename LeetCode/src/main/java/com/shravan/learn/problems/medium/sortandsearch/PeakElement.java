package com.shravan.learn.problems.medium.sortandsearch;

public class PeakElement {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // if elements are in increasing order, peak is on the right
            if (nums[mid] < nums[mid + 1]) left = mid + 1;
                // otherwise, peak is on the left
            else right = mid;
        }
        return left;
    }
}
