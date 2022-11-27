package com.lt.backtrack;

import java.util.*;

public class Subsets90 {
    private List<List<Integer>> res = new ArrayList<>();
    private Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0) return res;
        res.add(new ArrayList<>(path));
        Arrays.sort(nums);
        backTrack(nums, 0);
        return res;
    }

    private void backTrack(int[] nums, int start) {
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            path.offer(nums[i]);
            res.add(new ArrayList<>(path));
            backTrack(nums, i + 1);
            path.removeLast();
        }
    }
}
