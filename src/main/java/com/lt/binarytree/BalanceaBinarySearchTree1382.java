package com.lt.binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BalanceaBinarySearchTree1382 {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traverse(root, list);
        return buildTree(list, 0, list.size() - 1);
    }

    private void traverse(TreeNode root, List<Integer> list) {
        if (root == null) return;
        traverse(root.left, list);
        list.add(root.val);
        traverse(root.right, list);
    }

    private TreeNode buildTree(List<Integer> list, int begin, int end) {
        if (begin > end) return null;
        int mid = begin + (end - begin) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = buildTree(list, begin, mid - 1);
        root.right = buildTree(list, mid + 1, end);
        return root;
    }
}
