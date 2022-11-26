package com.lt.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum40 {
    private List<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);// sort first.
        backTrack(candidates, target, 0, 0);
        return res;
    }

    private void backTrack(int[] candidates, int target, int start, int sum) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (sum > target) return;

        for (int i = start; i < candidates.length && sum + candidates[i] <= target; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.add(candidates[i]);
            sum += candidates[i];
            backTrack(candidates, target, i + 1, sum);// should be i+1, not start+1.
            sum -= candidates[i];
            path.removeLast();
        }
    }
}
