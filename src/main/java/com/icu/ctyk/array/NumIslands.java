package com.icu.ctyk.array;

/**
 * @author ctykwz on 2021-06-07 19:44
 */
public class NumIslands {

    public static void main(String[] args) {
        int cnt = new NumIslands().numIslands(new char[][]{
                new char[]{'1', '0', '1', '1', '0', '1', '1'}
        });
        System.out.println(cnt);
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int cnt = 0;
        for (int rowIndex = 0; rowIndex < grid.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < grid[0].length; columnIndex++) {
                if (grid[rowIndex][columnIndex] == '1') {
                    cnt++;
                    dfs(grid, rowIndex, columnIndex);
                }
            }
        }
        return cnt;
    }


    private void dfs(char[][] grid, int rowIndex, int columnIndex) {
        if (rowIndex >= grid.length || columnIndex >= grid[0].length || columnIndex < 0 || rowIndex < 0) {
            // 越界了
            return;
        }
        if (grid[rowIndex][columnIndex] != '1') {
            // 已经找过了
            return;
        }
        grid[rowIndex][columnIndex] = '0';
        dfs(grid, rowIndex, columnIndex + 1);
        dfs(grid, rowIndex, columnIndex - 1);
        dfs(grid, rowIndex + 1, columnIndex);
        dfs(grid, rowIndex - 1, columnIndex);
    }
}
