package com.lt.binarytree;

public class ConvertBSTtoGreaterTree538 {
    private TreeNode pre;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        convertBST(root.right);
        if (pre != null) {
            root.val += pre.val;
        }
        pre = root;
        convertBST(root.left);
        return root;
    }
}
