package com.shravan.learn.problems.medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        ThreeSum solution = new ThreeSum();
        List<List<Integer>> threeSum = solution.threeSum(new int[]{
                -1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4
//                0,0,0,0
//                0,2,2,3,0,1,2,3,-1,-4,2
//                -1,0,1,2,-1,-4
//                -2,0,1,1,2
//                0,0,0
        });
        System.out.println("threeSum = " + threeSum);
    }

    // a + b + c = 0
    // fix a value for a and solve b + c = -a as a Two sum problem
    // if array is sorted, we can use two pointer technique instead of hash map
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int temp = Integer.MIN_VALUE;
        // since we need 3 numbers, we need to process till n - 2
        for (int i = 0; i < nums.length - 2; i++) {
            int a = nums[i];
            // if current number is same as previous then skip since it is already processed
            if (a != temp) {
                twoSum(result, nums, -a, i + 1, nums.length - 1);
                temp = a;
            }
        }
        return result;
    }

    private void twoSum(List<List<Integer>> result, int[] nums, int target, int start, int end) {
        while (start < end) {
            if (nums[start] + nums[end] == target) {
                result.add(Arrays.asList(-target, nums[start], nums[end]));
                int low = nums[start];
                int high = nums[end];
                // skip all duplicates of starting number
                while (start < end && nums[start] == low) start++;
                // skip all duplicates of ending number
                while (start < end && nums[end] == high) end--;
            } else if (nums[start] + nums[end] > target) {
                end--;
            } else {
                start++;
            }
        }
    }
}
