package com.lt.stackqueue;

import java.util.Deque;
import java.util.LinkedList;

public class SimplifyPath71 {
    public String simplifyPath(String path) {
        String[] dir = path.split("/");
        Deque<String> stack = new LinkedList<>();
        for (int i = 0; i < dir.length; i++) {
            String cur = dir[i];
            if (cur.isEmpty() || cur.equals(".")) {
                continue;
            } else if (cur.equals("..")) {
                if (stack.isEmpty()) continue;
                stack.pop();
            } else {
                stack.push(cur);
            }
        }
        int size = stack.size();
        String[] res = new String[size];
        int count = size - 1;
        while (!stack.isEmpty() && count >= 0) {
            res[count] = stack.pop();
            count--;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("/");
        for (int i = 0; i < size; i++) {
            sb.append(res[i]);
            if (i != size - 1) {
                sb.append("/");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SimplifyPath71 in = new SimplifyPath71();
        String res = in.simplifyPath("/home//foo/");
        System.out.println(res);
    }
}
