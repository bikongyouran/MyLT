package com.lt.binarytree;

import java.util.Deque;
import java.util.LinkedList;

public class SymmetricTree101 {
    //solution 1
//    public boolean isSymmetric(TreeNode root) {
//        if (root == null) return true;
//        return compare(root.left, root.right);
//    }
//
//    private boolean compare(TreeNode left, TreeNode right) {
//        if (left == null && right == null) return true;
//        else if (left != null && right == null) {
//            return false;
//        } else if (left == null && right != null) {
//            return false;
//        } else if (left != null && right != null && left.val != right.val) {
//            return false;
//        }
//        boolean out = compare(left.left, right.right);
//        boolean in = compare(left.right, right.left);
//        return out && in;
//    }

    //solution 2: use queue or stack.
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if (left == null && right == null) continue;
            if ((left != null && right == null) || (left == null && right != null)) return false;
            if (left != null && right != null && left.val != right.val) return false;

            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }
}
