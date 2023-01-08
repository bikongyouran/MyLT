package com.lt.dandiaostack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;

public class LargestRectangleinHistogram84 {
    public int largestRectangleArea(int[] heights) {
        int[] newHeights = new int[heights.length + 2];
        for (int i = 0; i < heights.length; i++) {
            newHeights[i + 1] = heights[i];
        }
        heights = newHeights;

        Deque<Integer> stack = new LinkedList<>();
        int sum = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int mid = stack.pop();
                int left = stack.peek();
                int h = heights[mid];
                int w = i - left - 1;
                sum = Math.max(sum, h * w);
            }
            stack.push(i);
        }
        return sum;
    }
}
