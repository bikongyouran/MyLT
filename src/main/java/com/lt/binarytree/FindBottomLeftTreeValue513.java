package com.lt.binarytree;

import java.util.Deque;
import java.util.LinkedList;

public class FindBottomLeftTreeValue513 {
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) return -1;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int target = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                if (i == 0) target = tmp.val;
                if (tmp.left != null) queue.offer(tmp.left);
                if (tmp.right != null) queue.offer(tmp.right);
            }
        }
        return target;
    }
}
