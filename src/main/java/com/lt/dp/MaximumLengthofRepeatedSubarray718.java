package com.lt.dp;

public class MaximumLengthofRepeatedSubarray718 {
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];
        for (int i = 0; i < nums1.length; i++) if (nums1[i] == nums2[0]) dp[i][0] = 1;
        for (int j = 0; j < nums2.length; j++) if (nums1[0] == nums2[j]) dp[0][j] = 1;
        int res = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j] && i > 0 && j > 0) dp[i][j] = dp[i - 1][j - 1] + 1;
                res = res > dp[i][j] ? res : dp[i][j];
            }
        }
        return res;
    }
}
