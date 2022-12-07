package com.lt.dp;

import javax.security.auth.login.CredentialException;

public class PartitionEqualSubsetSum416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) return false;
        sum = sum / 2;
        boolean[][] dp = new boolean[length + 1][sum + 1];
        for (int i = 0; i <= length; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (nums[i - 1] > j) dp[i][j] = dp[i - 1][j];
                else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[length][sum];
    }
}
