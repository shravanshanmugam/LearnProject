package com.shravan.learn.problems.medium.dynamicprogramming;

public class CanJump {
    public static void main(String[] args) {
        CanJump solution = new CanJump();
        int[] nums = new int[]{1, 1, 2, 0, 1, 3, 1, 0, 1, 1, 1, 0};
        boolean canJump = solution.canJump(nums);
        System.out.println("canJump = " + canJump);

    }

    // 1 1 2 0 1 3 1 0 1 1 1 0
    // 0 1 2 3 4 5 6 7 8 9 10 11
    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            // from the end, at each index, check if the next index is reachable
            // if it is not reachable, check if it is reachable from any of the previous indices
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}
