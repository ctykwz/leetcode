package com.icu.ctyk.array;

/**
 * @author ctykwz on 2021-06-07 20:19
 */
public class IslandPerimeter {

    public int islandPerimeter(int[][] grid) {
        int cnt = 0;
        for (int rowIndex = 0; rowIndex < grid.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < grid[0].length; columnIndex++) {
                if (grid[rowIndex][columnIndex] == 1) {
                    cnt += dfs(grid, rowIndex, columnIndex);
                }
            }
        }
        return cnt;
    }

    private int dfs(int[][] grid, int rowIndex, int columnIndex) {
        if (grid.length <= rowIndex || grid[0].length <= columnIndex || rowIndex < 0 || columnIndex < 0) {
            return 1;
        }
        if (grid[rowIndex][columnIndex] ==0) {
            return 1;
        }
        if (grid[rowIndex][columnIndex] != 1) {
            return 0;
        }
        grid[rowIndex][columnIndex] = 2;
        return dfs(grid, rowIndex, columnIndex + 1)
                + dfs(grid, rowIndex, columnIndex - 1)
                + dfs(grid, rowIndex + 1, columnIndex)
                + dfs(grid, rowIndex - 1, columnIndex);
    }
}
