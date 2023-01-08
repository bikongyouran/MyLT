package com.lt.dandiaostack;

import java.util.Deque;
import java.util.LinkedList;

public class TrappingRainWater42 {
    public int trap(int[] height) {
        if (height.length <= 2) return 0;
        int sum = 0;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int mid = stack.pop();
                if (!stack.isEmpty()) {
                    int left = stack.peek();
                    int h = Math.min(height[left], height[i]) - height[mid];
                    int w = i - left - 1;
                    sum += h * w;
                }
            }
            stack.push(i);
        }
        return sum;
    }
}
