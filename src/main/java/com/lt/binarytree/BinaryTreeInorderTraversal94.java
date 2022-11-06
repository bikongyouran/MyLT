package com.lt.binarytree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traversal(root, res);
        return res;
    }

    public void traversal(TreeNode node, List<Integer> res) {
        if (node == null) return;
        traversal(node.left, res);
        res.add(node.val);
        traversal(node.right, res);
    }
}
