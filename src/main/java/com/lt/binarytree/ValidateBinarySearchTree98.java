package com.lt.binarytree;

public class ValidateBinarySearchTree98 {
    private TreeNode pre;// not initialize it, use the first value to initialize to avoid the same Integer.MinValue.
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        boolean left = isValidBST(root.left);
        if (pre != null && pre.val >= root.val) return false;
        pre = root;
        boolean right = isValidBST(root.right);
        return left && right;
    }
}
