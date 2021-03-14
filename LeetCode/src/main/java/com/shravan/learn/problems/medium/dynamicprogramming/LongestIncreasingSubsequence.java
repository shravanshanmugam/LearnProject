package com.shravan.learn.problems.medium.dynamicprogramming;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        LongestIncreasingSubsequence solution = new LongestIncreasingSubsequence();

        int lengthOfLIS1 = solution.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
        System.out.println("lengthOfLIS1 = " + lengthOfLIS1);// 4

        int lengthOfLIS2 = solution.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3});
        System.out.println("lengthOfLIS2 = " + lengthOfLIS2);// 4

        int lengthOfLIS3 = solution.lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7});
        System.out.println("lengthOfLIS3 = " + lengthOfLIS3);// 1

        int lengthOfLIS4 = solution.lengthOfLIS(new int[]{4, 10, 4, 3, 8, 9});
        System.out.println("lengthOfLIS4 = " + lengthOfLIS4);// 3

        int lengthOfLIS5 = solution.lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6});
        System.out.println("lengthOfLIS5 = " + lengthOfLIS5);// 6

        int lengthOfLIS6 = solution.lengthOfLIS(new int[]{10, 11, 12, 7, 8, 9, 1, 2, 3, 4, 5});
        System.out.println("lengthOfLIS6 = " + lengthOfLIS6);// 5
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < dp.length; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            dp[i] = maxval + 1;
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }
}
