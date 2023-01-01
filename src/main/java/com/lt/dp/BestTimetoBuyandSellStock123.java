package com.lt.dp;

public class BestTimetoBuyandSellStock123 {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][5];
        dp[0][0] = 0; //无状态
        dp[0][1] = -prices[0]; //第一次持有
        dp[0][2] = 0; //第一次不持有
        dp[0][3] = -prices[0]; //第二次持有
        dp[0][4] = 0; //第二次不持有
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }
//        return Math.max(dp[prices.length - 1][2], Math.max(dp[prices.length - 1][4], dp[prices.length - 1][0]));
        return dp[prices.length - 1][4];
// 在动态规划结束后，由于我们可以进行不超过两笔交易，因此最终的答案在 0,2,4中，且为三者中的最大值。
// 然而我们可以发现，由于在初始条件中2,4的值已经为0，并且在状态转移的过程中我们维护的是最大值，因此2和4最终一定大于等于0。
// 同时，如果最优的情况对应的是恰好一笔交易，那么它也会因为我们在转移时允许在同一天买入并且卖出这一宽松的条件，从2转移到4，因此最终的答案即为4.
    }
}
