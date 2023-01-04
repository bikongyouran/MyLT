package com.lt.dp;

public class IsSubsequence392 {
    public boolean isSubsequence(String s, String t) {
        //solution 1: 双指针
        //solution 2: 动态规划，判断共同子序列长度dp
        int[][] dp = new int[s.length() + 1][t.length() + 1];

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = dp[i][j - 1];
            }
        }
        return dp[s.length()][t.length()] == s.length();
    }
}
