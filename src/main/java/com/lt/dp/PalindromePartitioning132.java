package com.lt.dp;

public class PalindromePartitioning132 {
    public int minCut(String s) {
        if (s == null || s.isEmpty()) return 0;
        if (s.length() == 1) return 0;
        int len = s.length();
        boolean[][] palindrome = new boolean[len][len];
        //首先计算出[i,j]是否是回文数
        for (int i = len - 1; i >= 0; i--) {
            for (int j = 0; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) palindrome[i][j] = true;
                    else palindrome[i][j] = palindrome[i + 1][j - 1];
                }
            }
        }

        //dp[i]表示从0到i最少切几刀
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) dp[i] = i;

        for (int i = 0; i < len; i++) {
            if (palindrome[0][i]) {//如果已经是回文数组了，就不需要切了，直接跳过
                dp[i] = 0;
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (palindrome[j + 1][i]) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[len - 1];
    }
}
