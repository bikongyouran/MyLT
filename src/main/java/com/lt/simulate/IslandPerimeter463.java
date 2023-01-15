package com.lt.simulate;

public class IslandPerimeter463 {
    public int islandPerimeter(int[][] grid) {
        int override = 0;
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    sum++;
                    if (i - 1 >= 0 && grid[i - 1][j] == 1) override++;
                    if (j - 1 >= 0 && grid[i][j - 1] == 1) override++;
                }
            }
        }
        return sum * 4 - override * 2;
    }
}
