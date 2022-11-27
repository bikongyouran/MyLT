package com.lt.backtrack;

import java.util.*;

public class IncreasingSubsequences491 {
    private List<List<Integer>> res = new ArrayList<>();
    private Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums == null || nums.length < 2) return res;
        backTrack(nums, 0);
        return res;
    }

    private void backTrack(int[] nums, int start) {
        if (path.size() > 1) {
            res.add(new ArrayList<>(path));
        }
//        Set<Integer> set = new HashSet<>();
        int[] set = new int[201];// since the input is -100 <= nums[i] <= 100, use array as the set.
        for (int i = start; i < nums.length; i++) {
//            if (!set.isEmpty() && set.contains(nums[i])) continue;
            if (set[nums[i] + 100] == 1) continue;
            if (!path.isEmpty() && path.getLast() > nums[i]) continue;
            path.offer(nums[i]);
//            set.add(nums[i]);
            set[nums[i] + 100] = 1;
            backTrack(nums, i + 1);
            path.removeLast();
        }
    }
}
