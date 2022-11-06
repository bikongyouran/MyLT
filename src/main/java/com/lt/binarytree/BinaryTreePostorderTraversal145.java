package com.lt.binarytree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traversal(root, res);
        return res;
    }

    public void traversal(TreeNode node, List<Integer> res) {
        if (node == null) return;
        traversal(node.left, res);
        traversal(node.right, res);
        res.add(node.val);
    }
}
