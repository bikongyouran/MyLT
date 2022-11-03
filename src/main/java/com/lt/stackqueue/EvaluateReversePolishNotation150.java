package com.lt.stackqueue;

import java.util.Deque;
import java.util.LinkedList;

public class EvaluateReversePolishNotation150 {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < tokens.length; i++) {
            String s = tokens[i];
            if (s.equals("+")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a + b);
            } else if (s.equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            } else if (s.equals("*")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a * b);
            } else if (s.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation150 in = new EvaluateReversePolishNotation150();
        String[] tokens = new String[] {"2","1","+","3","*"};
        int res = in.evalRPN(tokens);
        System.out.println(res);
    }
}
