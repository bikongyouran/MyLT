package com.lt.dp;

public class LastStoneWeight1049 {
    public int lastStoneWeightII(int[] stones) {
        int total = 0;
        for (int i = 0; i < stones.length; i++) {
            total += stones[i];
        }
        int sum = total / 2;

        int[][] dp = new int[stones.length + 1][sum + 1];
        for (int i = 0; i < stones.length + 1; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < sum + 1; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < stones.length + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (j < stones[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i - 1]] + stones[i - 1]);
                }
            }
        }
        int target = dp[stones.length][sum];
        return total - target * 2;
    }
}
