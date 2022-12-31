package com.lt.dp;

public class HouseRobber337 {
    public int rob(TreeNode root) {
        int[] res = rob1(root);
        return Math.max(res[0], res[1]);
    }

    private int[] rob1(TreeNode root) {
        int[] dp = new int[2];
        if (root == null) return dp;
        int[] left = rob1(root.left);
        int[] right = rob1(root.right);
        //not take root
        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        //take root
        dp[1] = root.val + left[0] + right[0];
        return dp;
    }
}
