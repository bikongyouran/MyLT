package com.lt.binarytree;

public class LowestCommonAncestorofaBinarySearchTree235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        TreeNode small;
        TreeNode big;
        if (p.val > q.val) {
            small = q;
            big = p;
        } else {
            small = p;
            big = q;
        }
        if (root.val > big.val) return lowestCommonAncestor(root.left, p, q);
        if (root.val < small.val) return lowestCommonAncestor(root.right, p, q);
        return root;
    }
}
