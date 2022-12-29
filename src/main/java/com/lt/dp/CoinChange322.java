package com.lt.dp;

import java.util.Arrays;

public class CoinChange322 {
    public int coinChange(int[] coins, int amount) {
        int max = Integer.MAX_VALUE;
        int[] dp = new int[amount + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = max;
        }
        dp[0] = 0;

        for (int i = 1; i < coins.length + 1; i++) {
            for (int j = coins[i - 1]; j < amount + 1; j++) {
                if (dp[j - coins[i - 1]] != max) {//only when the initial value is not max, put it into comparision.
                    dp[j] = Math.min(dp[j], dp[j - coins[i - 1]] + 1);
                }
            }
        }

        return dp[amount] == max ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1,2,5};
        int amount = 11;
        CoinChange322 in = new CoinChange322();
        int res = in.coinChange(coins, amount);
        System.out.println(res);
    }
}
