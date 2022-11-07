package com.lt.binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tmpList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                tmpList.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            res.add(tmpList);
        }
        return res;
    }
}
