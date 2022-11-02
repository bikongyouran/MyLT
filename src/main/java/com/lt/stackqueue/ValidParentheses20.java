package com.lt.stackqueue;

import java.util.Deque;
import java.util.LinkedList;

public class ValidParentheses20 {
    public boolean isValid(String s) {
        //solution 2 is always pushing right char into stack, code will be cleaner.
        if (s == null || s.length() == 0) return true;
        if (s.length() % 2 != 0) return false;

        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {// right char
                if (stack.isEmpty()) {//empty stack
                    return false;
                }
                char top = stack.pop();
                if (ch == ')' && top != '(') {
                    return false;
                } else if (ch == ']' && top != '[') {
                    return false;
                } else if (ch == '}' && top != '{') {
                    return false;
                }
            }
        }
        if (!stack.isEmpty()) return false;
        return true;
    }

    public static void main(String[] args) {
        ValidParentheses20 in = new ValidParentheses20();
        boolean res = in.isValid("()]");
        System.out.println(res);
    }
}
