package com.lt.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combinations77 {
    private List<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backTrack(n, k, 1);
        return res;
    }

    private void backTrack(int n, int k, int start) {
        if (path.size() == k) {
            res.add(new LinkedList<>(path));
            return;
        }
        for (int i = start; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            backTrack(n, k, i + 1);
            path.removeLast();
        }
    }
}
