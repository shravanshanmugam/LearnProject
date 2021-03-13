package com.shravan.learn.problems.easy.others;

public class MissingNumber {
    // nums = [0,3,1] => missing number = 2
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = n * (n + 1) / 2;
        int actual_sum = 0;
        for (int i = 0; i < nums.length; i++) {
            actual_sum += nums[i];
        }
        return sum - actual_sum;
    }
}
