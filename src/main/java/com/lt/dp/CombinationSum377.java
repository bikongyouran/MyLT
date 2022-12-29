package com.lt.dp;

public class CombinationSum377 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int j = 0; j < target + 1; j++) { //外层循环是target，可以保证排列的顺序覆盖.
            for (int i = 1; i < nums.length + 1; i++) {
                if (j >= nums[i - 1])
                    dp[j] = dp[j] + dp[j - nums[i - 1]];
            }
        }
        return dp[target];
    }
}
