package com.lt.binarytree;

public class MinimumAbsoluteDifferenceinBST530 {
    private int result = Integer.MAX_VALUE;
    private TreeNode pre;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;
        traversal(root);
        return result;
    }

    private void traversal(TreeNode root) {
        if (root == null) return;
        traversal(root.left);
        if (pre != null) {
            result = Math.min(result, root.val - pre.val);
        }
        pre = root;
        traversal(root.right);
    }
}
