package com.shravan.learn.problems.medium.trees;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    clearIsland(grid, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    // BFS - for each 1, check 4 neighbors
    // mark each visited 1 as true and set it to 0
    // number of BFS we had to perform is number of islands
    private void clearIsland(char[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length)
            return;
        if (visited[i][j]) return;
        if (grid[i][j] == '1') {
            grid[i][j] = '0';
            visited[i][j] = true;
            clearIsland(grid, i + 1, j, visited);
            clearIsland(grid, i - 1, j, visited);
            clearIsland(grid, i, j + 1, visited);
            clearIsland(grid, i, j - 1, visited);
        }
    }
}
