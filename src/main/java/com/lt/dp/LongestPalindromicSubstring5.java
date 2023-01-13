package com.lt.dp;

public class LongestPalindromicSubstring5 {
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) return s;
        if (s.length() == 1) return s;
        int maxLength = 0;
        int left = 0;
        int right = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLength) {
                    maxLength = j - i + 1;
                    left = i;
                    right = j;
                }
            }
        }
        return s.substring(left, right + 1);
    }

    public static void main(String[] args) {
        String s = "babad";
        LongestPalindromicSubstring5 in = new LongestPalindromicSubstring5();
        String res = in.longestPalindrome(s);
        System.out.println(res);
    }
}
