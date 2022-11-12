package com.lt.binarytree;

public class SumofLeftLeaves404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int sum = 0;

        if (root.left != null && root.left.left == null && root.left.right == null) {
            //find target
            sum = root.left.val;
            int rightSum = sumOfLeftLeaves(root.right);
            sum += rightSum;
            return sum;
        } else {
            int leftSum = sumOfLeftLeaves(root.left);
            int rightSum = sumOfLeftLeaves(root.right);
            sum = leftSum + rightSum;
            return sum;
        }
    }
}
