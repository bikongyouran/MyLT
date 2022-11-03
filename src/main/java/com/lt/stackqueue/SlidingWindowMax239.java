package com.lt.stackqueue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMax239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        PureIncreaseQueue myQueue = new PureIncreaseQueue();
        for (int i = 0; i < k; i++) {
            myQueue.offer(nums[i]);
        }
        res[0] = myQueue.peek();
        for (int i = k; i < nums.length; i++) {
            int in = nums[i];
            int out = nums[i - k];
            myQueue.poll(out);
            myQueue.offer(in);
            res[i - k + 1] = myQueue.peek();
        }
        return res;
    }

    class PureIncreaseQueue {
        Deque<Integer> deque = new LinkedList<>();

        public void poll(int value) {
            if (!deque.isEmpty() && deque.peek() == value) {
                deque.poll();
            }
        }

        public void offer(int value) {
            if (deque.isEmpty()) {
                deque.offer(value);
                return;
            }
            while (!deque.isEmpty() && deque.peekLast() < value) {
                deque.removeLast();
            }
            deque.offer(value);
        }

        public int peek(){
            return deque.peek();
        }
    }

    public static void main(String[] args) {
        SlidingWindowMax239 in = new SlidingWindowMax239();
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] res = in.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(res));
    }
}
