package com.shravan.learn.problems.easy.dynamicprogramming;

public class HouseRobber {
    public static void main(String[] args) {
        HouseRobber solution = new HouseRobber();
        int robbedSum = solution.rob(new int[]{
                10, 1, 1, 10
        });
        System.out.println("robbedSum = " + robbedSum);
    }

    // robber cannot rob adjacent houses
    // maximize amount that can be robbed
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        sum[1] = nums[1];
        sum[2] = sum[0] + nums[2];
        for (int i = 3; i < nums.length; i++) {
            sum[i] = nums[i] + Math.max(sum[i - 2], sum[i - 3]);
        }
        return Math.max(sum[nums.length - 1], sum[nums.length - 2]);
    }
}
