package com.lt.binarytree;

public class PathSum112 {
    boolean res = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        int count = targetSum - root.val;
        traversal(root, count);
        return res;
    }

    private void traversal(TreeNode node, int count) {
        if (node.left == null && node.right == null && count == 0) {
            res = true;
            return;
        }
        if (node.left == null && node.right == null && count != 0) {
            return ;
        }
        if (node.left != null) {
            count = count - node.left.val;
            traversal(node.left, count);
            count = count + node.left.val;
        }
        if (node.right != null) {
            count = count - node.right.val;
            traversal(node.right, count);
            count = count + node.right.val;
        }
    }

    public static void main(String[] args) {
        PathSum112 in = new PathSum112();
        TreeNode root = new TreeNode(10, null, null);
        boolean res = in.hasPathSum(root, 10);
        System.out.println(res);
    }
}
