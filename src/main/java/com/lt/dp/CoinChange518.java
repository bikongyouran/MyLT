package com.lt.dp;

public class CoinChange518 {
    //solution 1: two-dimensions DP table.
//    public int change(int amount, int[] coins) {
//        if (coins == null || coins.length == 0) return 0;
//
//        int[][] dp = new int[coins.length + 1][amount + 1];
//        dp[0][0] = 1;
//
//        for (int i = 1; i < dp.length; i++) {
//            for (int j = 0; j < dp[0].length; j++) {
//                if (coins[i - 1] > j) dp[i][j] = dp[i - 1][j];
//                else {
//                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];//dp[i][j - coins[i - 1]]和0-1背包不一样，因为可以重复取，所以用dp[i].
//                }
//            }
//        }
//        return dp[coins.length][amount];
//    }

    //solution 2: one-dimension DP table.
    public int change(int amount, int[] coins) {
        if (coins == null || coins.length == 0) return 0;

        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int i = 1; i < coins.length + 1; i++) {
            for (int j = coins[i - 1]; j < amount + 1; j++) {//different with two-dimension, initialize j not 0.
                dp[j] = dp[j] + dp[j - coins[i - 1]];
            }
        }
        return dp[amount];
    }
}
