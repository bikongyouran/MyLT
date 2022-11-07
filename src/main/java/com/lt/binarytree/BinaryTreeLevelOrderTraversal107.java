package com.lt.binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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

        reverse(res);
        return res;
    }

    private void reverse(List<List<Integer>> res) {
        int len = res.size();
        for (int i = 0; i < len/2; i++) {
            List<Integer> tmp;
            tmp = res.get(i);
            res.set(i, res.get(len - i - 1));
            res.set(len - 1 - i, tmp);
        }
    }
}
