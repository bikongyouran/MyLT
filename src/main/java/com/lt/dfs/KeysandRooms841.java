package com.lt.dfs;

import java.util.List;

public class KeysandRooms841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int roomSize = rooms.size();
        boolean[] visited = new boolean[roomSize];
        dfs(rooms, visited, 0);
        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }

    private void dfs(List<List<Integer>> rooms, boolean[] visited, int key) {
        if (visited[key]) return;
        visited[key] = true;
        List<Integer> keys = rooms.get(key);
        for (int subKey : keys) {
            dfs(rooms, visited, subKey);
        }
    }
}
