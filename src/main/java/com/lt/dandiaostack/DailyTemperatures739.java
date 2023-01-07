package com.lt.dandiaostack;

import java.util.Deque;
import java.util.LinkedList;

public class DailyTemperatures739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        for (int i = 1; i < temperatures.length; i++) {
            while (stack.peek() != null && temperatures[i] > temperatures[stack.peek()]) {
                int top = stack.pop();
                res[top] = i - top;

            }
            stack.push(i);
        }
        return res;
    }
}
