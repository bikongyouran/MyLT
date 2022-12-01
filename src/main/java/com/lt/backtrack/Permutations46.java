package com.lt.backtrack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Permutations46 {
    private List<List<Integer>> res = new ArrayList<>();
    private Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return res;
        boolean[] used = new boolean[nums.length];// or by deciding if the elements in path are duplicated.
        backTrack(nums, used);
        return res;
    }

    private void backTrack(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            path.offer(nums[i]);
            used[i] = true;
            backTrack(nums, used);
            path.removeLast();
            used[i] = false;
        }
    }
}
