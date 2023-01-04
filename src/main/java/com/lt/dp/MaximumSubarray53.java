package com.lt.dp;

public class MaximumSubarray53 {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            res = res > dp[i] ? res : dp[i];
        }
        return res;
    }
}
