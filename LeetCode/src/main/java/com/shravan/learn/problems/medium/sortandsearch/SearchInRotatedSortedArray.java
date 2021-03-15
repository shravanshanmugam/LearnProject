package com.shravan.learn.problems.medium.sortandsearch;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        // find descending point where rotated array is decreasing
        int descPoint = descPoint(nums);
        // if no rotation, binary search in entire array
        if (descPoint == -1)
            return binarySearch(nums, target, 0, nums.length - 1);
        // binary search left side of descending point
        int leftAns = binarySearch(nums, target, 0, descPoint - 1);
        // binary serch right side of descending point
        int rightAns = binarySearch(nums, target, descPoint, nums.length - 1);
        if (leftAns == -1 && rightAns == -1) return -1;
        if (leftAns != -1) return leftAns;
        else return rightAns;
    }

    private int binarySearch(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    private int descPoint(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] < nums[i])
                return i + 1;
        }
        return -1;
    }
}
