package com.lt.backtrack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Subsets78 {
    private List<List<Integer>> res = new ArrayList<>();
    private Deque<Integer> path = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) return res;
        res.add(new ArrayList<>(path));
        backTrack(nums, 0);
        return res;
    }

    private void backTrack(int[] nums, int start) {
        for (int i = start; i < nums.length; i++) {
            path.offer(nums[i]);
            res.add(new ArrayList<>(path));
            backTrack(nums, i + 1);
            path.removeLast();
        }
    }
}
