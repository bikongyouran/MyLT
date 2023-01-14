package com.lt.dp;

import java.util.Arrays;

public class NumberofLongestIncreasingSubsequence673 {
    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int[] count = new int[nums.length];
        Arrays.fill(count, 1);

        int[] res = new int[2];
        res[0] = 1;//存子序列长度最长的值
        res[1] = 1;//存对应的个数

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        count[i] = count[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        count[i] += count[j];
                    }
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (res[0] < dp[i]) {
                res[0] = dp[i];
                res[1] = count[i];
            } else if (res[0] == dp[i]) {
                res[1] += count[i];
            }
        }
        return res[1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,2,2,2};
        NumberofLongestIncreasingSubsequence673 in = new NumberofLongestIncreasingSubsequence673();
        int res = in.findNumberOfLIS(nums);
        System.out.println(res);
    }
}
