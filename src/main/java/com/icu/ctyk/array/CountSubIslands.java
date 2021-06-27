package com.icu.ctyk.array;

/**
 * [[1,0,1,0,1],[1,1,1,1,1],[0,0,0,0,0],[1,1,1,1,1],[1,0,1,0,1]]
 * [[0,0,0,0,0],[1,1,1,1,1],[0,1,0,1,0],[0,1,0,1,0],[1,0,0,0,1]]
 *
 * @author ctykwz on 2021-06-27 09:21
 */
public class CountSubIslands {

    public static void main(String[] args) {
        System.out.println(
                new CountSubIslands().countSubIslands(
                        new int[][]{
                                new int[]{1, 0, 1, 0, 1},
                                new int[]{1, 1, 1, 1, 1},
                                new int[]{0, 0, 0, 0, 0},
                                new int[]{1, 1, 1, 1, 1},
                                new int[]{1, 0, 1, 0, 1}
                        },
                        new int[][]{
                                new int[]{0, 0, 0, 0, 0},
                                new int[]{1, 1, 1, 1, 1},
                                new int[]{0, 1, 0, 1, 0},
                                new int[]{0, 1, 0, 1, 0},
                                new int[]{1, 0, 0, 0, 1}
                        }
                )
        );
    }

    private static boolean valid = true;

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int cnt = 0;
        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[i].length; j++) {
                if (grid2[i][j] == 1) {
                    valid = true;
                    dfs(grid1, grid2, i, j);
                    if (valid) {
                        cnt += 1;
                    }
                }
            }
        }
        return cnt;
    }

    private void dfs(int[][] grid1, int[][] grid2, int row, int col) {
        if (row < 0 || row >= grid2.length || col < 0 || col >= grid2[0].length || grid2[row][col] != 1) {
            return;
        }
        if (grid1[row][col] == 0) {
            valid = false;
        }
        grid2[row][col] = 0;
        dfs(grid1, grid2, row + 1, col);
        dfs(grid1, grid2, row - 1, col);
        dfs(grid1, grid2, row, col + 1);
        dfs(grid1, grid2, row, col - 1);
    }
}
