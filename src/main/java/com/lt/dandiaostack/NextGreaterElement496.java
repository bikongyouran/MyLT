package com.lt.dandiaostack;

import java.util.*;

public class NextGreaterElement496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                int top = stack.pop();
                if (map.containsKey(nums2[top])) {
                    int targetIndex = map.get(nums2[top]);
                    res[targetIndex] = nums2[i];
                }
            }
            stack.push(i);
        }
        return res;
    }
}
