package com.lt.dp;

public class IntegerBreak343 {
    public int integerBreak(int n) {
        if (n < 2) return 0;
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i/2; j++) {
                // fix i, j will have multiple values, so there will be multiple dp[i],
                // so need to add dp[i] for comparison.
                dp[i] = Math.max(dp[i],Math.max(j * dp[i - j], j * (i - j)));
            }
        }
        return dp[n];
    }
}
