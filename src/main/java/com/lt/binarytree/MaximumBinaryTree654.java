package com.lt.binarytree;

public class MaximumBinaryTree654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return buildTree(nums, 0, nums.length);
    }

    private TreeNode buildTree(int[] nums, int start, int end) {
        if (start >= end) return null;
        if (nums.length == 1) {
            int val = nums[0];
            TreeNode root = new TreeNode(val);
            return root;
        }
        int maxValue = Integer.MIN_VALUE;
        int maxIndex = 0;
        for (int i = start; i < end; i++) {
            if (nums[i] > maxValue) {
                maxValue = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(maxValue);
        if (maxIndex == start) {
            root.right = buildTree(nums, maxIndex + 1, end);
            return root;
        }
        if (maxIndex == end - 1) {
            root.left = buildTree(nums, start, end - 1);
            return root;
        }
        root.left = buildTree(nums, start, maxIndex);
        root.right = buildTree(nums, maxIndex + 1, end);
        return root;
    }
}
