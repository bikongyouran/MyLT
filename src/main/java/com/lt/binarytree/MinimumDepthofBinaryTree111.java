package com.lt.binarytree;

import java.util.Deque;
import java.util.LinkedList;

public class MinimumDepthofBinaryTree111 {
    //solution 1
//    public int minDepth(TreeNode root) {
//        if (root == null) return 0;
//        Deque<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        int depth = 0;
//        while (!queue.isEmpty()) {
//            depth++;
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                TreeNode node = queue.poll();
//                if (node.left == null && node.right == null) return depth;
//                if (node.left != null) queue.offer(node.left);
//                if (node.right != null) queue.offer(node.right);
//            }
//        }
//        return depth;
//    }

    //solution 2
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) {
            int depth = minDepth(root.right);
            return depth + 1;
        }
        if (root.right == null) {
            int depth = minDepth(root.left);
            return depth + 1;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return left < right ? (left + 1) : (right + 1);
    }
}
