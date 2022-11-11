package com.lt.binarytree;

public class BalancedBinaryTree110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int leftDepth = calculateMaxTreeDepth(root.left);
        int rightDepth = calculateMaxTreeDepth(root.right);
        if (Math.abs(leftDepth - rightDepth) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int calculateMaxTreeDepth(TreeNode node) {
        if (node == null) return 0;
        int leftDepth = calculateMaxTreeDepth(node.left);
        int rightDepth = calculateMaxTreeDepth(node.right);
        return leftDepth > rightDepth ? (leftDepth + 1) : (rightDepth + 1);
    }

}
