package com.lt.stackqueue;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUseQueue225 {
    private Queue<Integer> q = new LinkedList<>();

    public ImplementStackUseQueue225() {

    }

    public void push(int x) {
        q.offer(x);
    }

    public int pop() {
        if (q.size() == 0 || q.size() == 1) return q.poll();
        int size = q.size();
        for(int i = 0; i < size - 1; i++) {
            int head = q.poll();
            q.offer(head);
        }
        return q.poll();
    }

    public int top() {
        int top = this.pop();
        this.push(top);
        return top;
    }

    public boolean empty() {
        return q.isEmpty();
    }
}
