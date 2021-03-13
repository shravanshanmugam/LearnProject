package com.shravan.learn.problems.easy.dynamicprogramming;

public class BuyAndSellStock {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                // update min value
                min = prices[i];
            } else if (prices[i] - min > profit) {
                // update profit
                profit = prices[i] - min;
            }
        }
        return profit;
    }
}
