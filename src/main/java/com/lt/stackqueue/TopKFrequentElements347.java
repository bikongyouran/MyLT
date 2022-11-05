package com.lt.stackqueue;

import java.util.*;

public class TopKFrequentElements347 {
    public int[] topKFrequent(int[] nums, int k) {
        // 1. set map: key/count
        // 2. 构造小顶堆
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (count < k) {
                queue.offer(new int[]{entry.getKey(), entry.getValue()});
            } else {
                if (queue.peek()[1] < entry.getValue()) {
                    queue.poll();
                    queue.offer(new int[]{entry.getKey(), entry.getValue()});
                }
            }
            count++;
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll()[0];
        }
        return res;
    }

    public static void main(String[] args) {
        TopKFrequentElements347 in = new TopKFrequentElements347();
        int[] nums = new int[]{1,1,1,2,2,3};
        int k = 2;
        int[] res = in.topKFrequent(nums, k);
        System.out.println(Arrays.toString(res));
    }
}
