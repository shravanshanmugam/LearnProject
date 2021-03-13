package com.shravan.learn.problems.easy.dynamicprogramming;

public class ClimbingStairs {
    // how many distinct ways to climb when you can take 1 or 2 steps
    public int climbStairs(int n) {
        int[] steps = new int[n + 1];
        steps[0] = 1;
        steps[1] = 1;
        for (int i = 2; i <= n; i++) {
            // 1 step, no of steps of n-1 + 2steps, no of steps of n-2
            steps[i] = steps[i - 1] + steps[i - 2];
        }
        return steps[n];
    }
}
