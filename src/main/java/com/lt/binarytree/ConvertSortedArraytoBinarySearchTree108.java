package com.lt.binarytree;

public class ConvertSortedArraytoBinarySearchTree108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) return null;
        if (start == end) {
            return new TreeNode(nums[start]);
        }
        int mid = (end - start + 1) / 2;
        TreeNode root = new TreeNode(nums[start + mid]);
        root.left = buildTree(nums, start, start + mid - 1);
        root.right = buildTree(nums, start + mid + 1, end);
        return root;
    }
}
