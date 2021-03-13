package com.shravan.learn.problems.easy.dynamicprogramming;

public class MaximumSumSubArray {
    public int maxSubArray(int[] nums) {
        // Kadane's Algorithm
        int maxSum = Integer.MIN_VALUE, currSum = 0;
        for (int num : nums) {
            currSum = currSum + num;
            // if max sum is less than current sum, then update max sum
            if (maxSum < currSum)
                maxSum = currSum;
            // if current sum is less than 0, then reset current sum to 0
            if (currSum < 0)
                currSum = 0;
        }
        return maxSum;
    }
}
