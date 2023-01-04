package com.lt.dp;

public class LongestCommonSubsequence1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        if (text1.charAt(0) == text2.charAt(0)) dp[0][0] = 1;
        for (int i = 1; i < text1.length(); i++) {
            if (text1.charAt(i) == text2.charAt(0)) dp[i][0] = 1;
            else dp[i][0] = dp[i - 1][0];
        }
        for (int j = 1; j < text2.length(); j++) {
            if (text1.charAt(0) == text2.charAt(j)) dp[0][j] = 1;
            else dp[0][j] = dp[0][j - 1];
        }

        for (int i = 1; i < text1.length(); i++) {
            for (int j = 1; j < text2.length(); j++) {
                if (text1.charAt(i) == text2.charAt(j)) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[text1.length() - 1][text2.length() - 1];
    }
}
