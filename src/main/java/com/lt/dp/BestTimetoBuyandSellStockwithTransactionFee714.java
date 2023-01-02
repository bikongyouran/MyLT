package com.lt.dp;

public class BestTimetoBuyandSellStockwithTransactionFee714 {
    public int maxProfit(int[] prices, int fee) {
        //交易费是指一笔交易包含买进和卖出
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0; //不持有股票
        dp[0][1] = -prices[0]; //持有股票，只买进没有手续费
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]);
    }
}
