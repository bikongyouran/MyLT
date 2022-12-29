package com.lt.dp;

public class TargetSum494 {
    public int findTargetSumWays(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if ((sum + target) % 2 != 0) return 0;
        int x = (sum + target) / 2;
        if (x < 0) return 0;//x means all positive sum, if it is less than 0, means no ways.
        int[][] dp = new int[nums.length + 1][x + 1];
        dp[0][0] = 1;
        //consider the array may contain 0 as element.
//        for (int i = 0; i < dp.length; i++) {
//            dp[i][0] = 1;
//        }
        for (int j = 1; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (nums[i - 1] > j) dp[i][j] = dp[i - 1][j];
                else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[nums.length][x];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,0,0,0,0,0,0,1};
        int target = 1;
        TargetSum494 in = new TargetSum494();
        int res = in.findTargetSumWays(nums, target);
        System.out.println(res);
    }
}
