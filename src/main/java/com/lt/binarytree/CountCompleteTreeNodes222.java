package com.lt.binarytree;

public class CountCompleteTreeNodes222 {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        //退出条件，满二叉树时直接返回计数
        int leftCount = 0, rightCount = 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        while (left != null) {
            left = left.left;
            leftCount++;
        }
        while (right != null) {
            right = right.right;
            rightCount++;
        }
        if (leftCount == rightCount) {
            return (2 << leftCount) - 1;
        }
        int leftNum = countNodes(root.left);
        int rightNum = countNodes(root.right);
        return leftNum + rightNum + 1;
    }
}
