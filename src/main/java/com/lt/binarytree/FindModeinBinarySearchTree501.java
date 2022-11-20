package com.lt.binarytree;

import java.util.ArrayList;
import java.util.List;

public class FindModeinBinarySearchTree501 {
    private TreeNode pre;
    private List<Integer> res = new ArrayList<>();
    private int count = 0;
    private int maxCount = 0;

    public int[] findMode(TreeNode root) {
        if (root == null) return new int[]{};
        traversal(root);
        int[] r = res.stream().mapToInt(Integer::intValue).toArray();
        return r;
    }

    private void traversal(TreeNode root) {
        if (root == null) return;
        traversal(root.left);
        if (pre == null) {
            count = 1;
        } else if (pre.val == root.val) {
            count++;
        } else {
            count = 1;
        }
        pre = root;

        if (count == maxCount) {
            res.add(pre.val);
        }
        if (count > maxCount) {
            res.clear();
            maxCount = count;
            res.add(pre.val);
        }
        traversal(root.right);
    }
}
