package com.lt.bingchaji;

public class RedundantConnection684 {
    //并查集模板
    private int n;
    private int[] father;
    public RedundantConnection684 () {
        n = 1000;
        father = new int[n];

        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
    }

    public int find(int v) {
        if (v == father[v]) return v;
        father[v] = find(father[v]);
        return father[v];
    }

    private void join(int u, int v) {
        u = find(u);
        v = find(v);
        if (u == v) return;
        father[v] = u;
    }

    private boolean isSame(int u, int v){
        u = find(u);
        v = find(v);
        return u == v;
    }

    public int[] findRedundantConnection(int[][] edges) {
        for (int i = 0; i < edges.length; i++) {
            if (isSame(edges[i][0], edges[i][1])){
                return edges[i];
            } else {
                join(edges[i][0], edges[i][1]);
            }
        }
        return null;
    }
}
