package com.shravan.learn.problems.medium.dynamicprogramming;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
        CoinChange solution = new CoinChange();
        int minCoins = solution.coinChange(new int[]{1, 2, 5}, 11);
        System.out.println("minCoins = " + minCoins);
    }

    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
