package com.lt.stackqueue;

import java.util.Deque;
import java.util.LinkedList;

public class RemoveAllAdjacentDuplicatesInString1047 {
    public String removeDuplicates(String s) {
        Deque<Character> stack = new LinkedList<>();
        int len = s.length();
        for (int i = len - 1; i >=0; i--) {
            if (!stack.isEmpty()) {
                char top = stack.peek();
                if (top == s.charAt(i)) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveAllAdjacentDuplicatesInString1047 in = new RemoveAllAdjacentDuplicatesInString1047();
        String res = in.removeDuplicates("abbaca");
        System.out.println(res);
    }
}
