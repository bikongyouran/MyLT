package com.lt.binarytree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreefromInorderandPostorderTraversal106 {
    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder == null || postorder.length == 0) return null;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    //左闭右开
    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart >= inEnd || postStart >= postEnd) return null;
        int rootValue = postorder[postEnd - 1];
        TreeNode root = new TreeNode(rootValue);
        int inDelimiter = map.get(rootValue);
        root.left = buildTree(inorder, inStart, inDelimiter, postorder, postStart, postStart + inDelimiter - inStart);
        root.right = buildTree(inorder, inDelimiter + 1, inEnd, postorder, postStart + inDelimiter - inStart, postEnd - 1);
        return root;
    }

}
