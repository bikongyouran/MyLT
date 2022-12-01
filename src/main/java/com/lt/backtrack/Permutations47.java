package com.lt.backtrack;

import java.util.*;

public class Permutations47 {
    private List<List<Integer>> res = new ArrayList<>();
    private Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        backTrack(nums, visited);
        return res;
    }

    private void backTrack(int[] nums, boolean[] visited) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
            if (visited[i]) continue;

            path.offer(nums[i]);
            visited[i] = true;
            backTrack(nums, visited);
            path.removeLast();
            visited[i] = false;
        }
    }
}
