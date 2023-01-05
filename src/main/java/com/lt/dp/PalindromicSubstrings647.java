package com.lt.dp;

public class PalindromicSubstrings647 {
    public int countSubstrings(String s) {
        if (s == null || s.isEmpty()) return 0;
        if (s.length() == 1) return 1;
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int res = 0;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (s.charAt(i) != s.charAt(j)) dp[i][j] = false;
                else {
                    if (j - i <= 1) {
                        dp[i][j] = true;
                        res++;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                        if (dp[i][j]) res++;
                    }
                }
            }
        }
        return res;
    }
}
