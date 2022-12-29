package com.lt.dp;

public class OnesandZeroes474 {
    public int findMaxForm(String[] strs, int m, int n) {
        if (strs == null || strs.length == 0) return 0;
        //滚动数组降维，但是需要倒序遍历，只和上一个状态有关，避免重复计算本层的前面
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;// actually the default value is 0. explicitly set 0 here for better understanding.
        for (int i = 1; i < strs.length + 1; i++) {//start from 1, 表示前几个的意思，更好理解
            int[] res = getZerosOnes(strs[i - 1]);
            for (int j = m; j >= res[0]; j--) {
                for (int k = n; k >= res[1]; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - res[0]][k - res[1]] + 1);
                }
            }
        }
        return dp[m][n];
    }

    private int[] getZerosOnes(String str) {
        int[] res = new int[2];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            res[c - '0']++;
        }
        return res;
    }
}
