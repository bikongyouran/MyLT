package com.lt.dp;

import java.util.List;

public class WordBreak139 {
    public boolean wordBreak(String s, List<String> wordDict) {//完全背包
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int j = 1; j < s.length() + 1; j++) {
            for (int i = 0; i < j + 1; i++) {
                String word = s.substring(i, j);
                if (dp[i] && wordDict.contains(word)) {
                    dp[j] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
