package com.lt.dandiaostack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class NextGreaterElement503 {
    public int[] nextGreaterElements(int[] nums) {
        //循环数组一般要拼接一下变成长度为2倍的数组
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < nums.length * 2; i++) {
            while (!stack.isEmpty() && nums[i % nums.length] > nums[stack.peek()]) {
                int top = stack.pop();
                res[top] = nums[i % nums.length];
            }
            stack.push(i % nums.length);
        }
        return res;
    }

    public static void main(String[] args) {
        NextGreaterElement503 in = new NextGreaterElement503();
        int[] nums = new int[]{1,2,1};
        int[] res = in.nextGreaterElements(nums);
        System.out.println(Arrays.toString(res));
    }
}
