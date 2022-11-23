package com.lt.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum39 {
    private List<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return res;
        int sum = 0;
        Arrays.sort(candidates);//sort first otherwise the condition "sum + candidates[i] <= target" is wrong.
        backTrack(candidates, target, 0, sum);
        return res;
    }

    private void backTrack(int[] candidates, int target, int index, int sum) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (sum > target) return;

        int length = candidates.length;
        for (int i = index; i < length && (sum + candidates[i] <= target); i++) {
            path.add(candidates[i]);
            sum += candidates[i];
            backTrack(candidates, target, i, sum);
            path.removeLast();
            sum -= candidates[i];
        }
    }

    public static void main(String[] args) {
        CombinationSum39 in = new CombinationSum39();
        int[] candidates = new int[]{8,7,4,3};
        int target = 11;
        List<List<Integer>> res = in.combinationSum(candidates, target);
        System.out.println(res);
    }
}
