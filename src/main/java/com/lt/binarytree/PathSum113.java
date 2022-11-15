package com.lt.binarytree;

import java.util.ArrayList;
import java.util.List;

public class PathSum113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        int count = targetSum - root.val;
        List<Integer> tmp = new ArrayList<>();
        tmp.add(root.val);
        traversal(root, count, tmp, res);
        return res;
    }

    private void traversal(TreeNode node, int count, List<Integer> tmp, List<List<Integer>> res) {
        if (node.left == null && node.right == null && count == 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        if (node.left == null && node.right == null && count != 0) {
            return ;
        }
        if (node.left != null) {
            count = count - node.left.val;
            tmp.add(node.left.val);
            traversal(node.left, count, tmp, res);
            count = count + node.left.val;
            int size = tmp.size();
            tmp.remove(size - 1);
        }
        if (node.right != null) {
            count = count - node.right.val;
            tmp.add(node.right.val);
            traversal(node.right, count, tmp, res);
            count = count + node.right.val;
            int size = tmp.size();
            tmp.remove(size - 1);
        }
    }
}
