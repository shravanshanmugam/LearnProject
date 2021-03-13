package com.shravan.learn.problems.easy.array;

public class BuyAndSellStock {
    public static void main(String[] args) {
        BuyAndSellStock solution = new BuyAndSellStock();
        int maxProfit = solution.maxProfit(new int[]{
                7, 1, 5, 3, 6, 4
        });
        System.out.println("maxProfit = " + maxProfit);
    }

    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                // total profit = sum of smaller profits made in consecutive days
                maxprofit += prices[i] - prices[i - 1];
            }
        }
        return maxprofit;
    }
}
