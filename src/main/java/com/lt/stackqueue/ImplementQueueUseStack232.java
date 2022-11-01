package com.lt.stackqueue;

import java.util.Stack;

public class ImplementQueueUseStack232 {
    private Stack<Integer> in = new Stack<>();
    private Stack<Integer> out = new Stack<>();

    public ImplementQueueUseStack232() {

    }

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                int top = in.pop();
                out.push(top);
            }
        }
        return out.pop();
    }

    public int peek() {
        int top = this.pop();
        out.push(top);
        return top;
    }

    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}
