package com.lt.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SumRoottoLeafNumbers129 {
    private List<Integer> path = new ArrayList<>();
    private int total = 0;
    public int sumNumbers(TreeNode root) {
        path.add(root.val);
        traversal(root);
        return total;
    }

    private void traversal(TreeNode tmp) {
        if (tmp.left == null && tmp.right == null) {//遇到叶子节点，计算这条路径的值
            int sum = 0;
            for (int i = 0; i < path.size(); i++) {
                int value = path.get(i);
                sum = sum * 10 + value;
            }
            total += sum;
            return;
        }
        if (tmp.left != null) {
            path.add(tmp.left.val);
            traversal(tmp.left);
            path.remove(path.size() - 1);
        }
        if (tmp.right != null) {
            path.add(tmp.right.val);
            traversal(tmp.right);
            path.remove(path.size() - 1);
        }
    }
}
