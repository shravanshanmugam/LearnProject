package com.shravan.learn.problems.medium.sortandsearch;

import java.util.Arrays;

public class SearchForRange {
    public static void main(String[] args) {
        SearchForRange solution = new SearchForRange();
        int[] range = solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        System.out.println("range = " + Arrays.toString(range));
    }

    public int[] searchRange(int[] nums, int target) {
        // find index where element is present
        int index = binarySearch(nums, target);
        // element does not exist in array
        if (index == -1) return new int[]{-1, -1};

        int left = index, right = index;
        // find left most index in array which equals target
        while (left >= 0 && nums[left] == target) {
            left--;
        }
        // find right most index in array which equals target
        while (right < nums.length && nums[right] == target) {
            right++;
        }
        return new int[]{left + 1, right - 1};
    }

    private int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            // Prevent (left + right) overflow
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // End Condition: left > right
        return -1;
    }
}
