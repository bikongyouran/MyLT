package com.lt.binarytree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traversal(root, res);
        return res;
    }

    public void traversal(TreeNode node, List<Integer> res) {
        if (node == null) return;
        res.add(node.val);
        traversal(node.left, res);
        traversal(node.right, res);
    }
}
