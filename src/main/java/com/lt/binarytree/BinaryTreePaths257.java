package com.lt.binarytree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if (root == null) return res;
        path.add(root.val);
        traversal(root, res, path);
        return res;
    }

    private void traversal(TreeNode root, List<String> res, List<Integer> path) {
        //退出条件
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size() - 1; i++) {
                sb.append(path.get(i));
                sb.append("->");
            }
            sb.append(path.get(path.size() - 1));
            res.add(sb.toString());
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        //遍历所有选择
        if (left != null) {
            path.add(left.val);//选择
            traversal(left, res, path);//回溯
            path.remove(path.size() - 1);//撤销选择
        }
        if (right != null) {
            path.add(right.val);
            traversal(right, res, path);
            path.remove(path.size() - 1);
        }
    }
}
