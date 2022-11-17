package com.lt.binarytree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreefromPreorderandInorderTraversal105 {
    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0) return null;

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart >= preEnd || inStart >= inEnd) return null;
        int rootValue = preorder[preStart];
        TreeNode root = new TreeNode(rootValue);
        int inorderIndex = map.get(rootValue);
        int len = inorderIndex - inStart;
        root.left = buildTree(preorder, preStart + 1, preStart + 1 + len, inorder, inStart, inorderIndex);
        root.right = buildTree(preorder, preStart + 1 + len, preEnd, inorder, inorderIndex + 1, inEnd);
        return root;
    }

}
