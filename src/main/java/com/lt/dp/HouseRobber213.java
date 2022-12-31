package com.lt.dp;

public class HouseRobber213 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return nums[0] > nums[1] ? nums[0] : nums[1];
        return Math.max(robRange(nums, 0, nums.length - 2), robRange(nums, 1, nums.length - 1));
    }

    //solution 1
//    private int robRange(int[] nums, int start, int end) {
//        if (start == end) return nums[start];
//        int[] dp = new int[nums.length];
//        dp[start] = nums[start];
//        dp[start + 1] = nums[start] > nums[start + 1] ? nums[start] : nums[start + 1];
//
//        for (int i = start + 2; i <= end; i++) {
//            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
//        }
//        return dp[end];
//    }

    //solution 2, 优化变量
    private int robRange(int[] nums, int start, int end) {
        if (start == end) return nums[start];
        if (end - start == 1) return nums[start] > nums[start + 1] ? nums[start] : nums[start + 1];
        int first = nums[start];
        int second = nums[start] > nums[start + 1] ? nums[start] : nums[start + 1];
        int tmp = 0;

        for (int i = start + 2; i <= end; i++) {
            tmp = Math.max(second, first + nums[i]);
            first = second;
            second = tmp;
        }
        return tmp;
    }
}
