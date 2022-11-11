package com.lt.binarytree;

import java.util.List;

public class MaximumDepthofNaryTree559 {
    public int maxDepth(Node root) {
        if (root == null) return 0;
        int tmp = 0;
        for (Node node : root.children) {
            int depth = maxDepth(node);
            tmp = tmp > depth ? tmp : depth;
        }
        return tmp + 1;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
