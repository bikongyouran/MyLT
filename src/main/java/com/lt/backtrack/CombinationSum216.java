package com.lt.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum216 {
    private List<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(k, n, 1, 0);
        return res;
    }

    private void backtrack(int k, int n, int start, int sum) {
        if (path.size() == k && sum == n) {
            res.add(new LinkedList<>(path));
            return;
        }
        if (sum > n || start > n - sum) return;
        for (int i = start; i < 10; i++) {
            path.add(i);
            sum += i;
            backtrack(k, n, i + 1, sum);
            path.removeLast();
            sum -= i;
        }
    }
}
