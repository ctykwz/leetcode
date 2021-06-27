package com.icu.ctyk.array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ctykwz on 2021-06-27 17:57
 */
public class OrangesRotting {

    public static void main(String[] args) {
        System.out.println(
                new OrangesRotting().orangesRotting(
                        new int[][]{
                                new int[]{2, 1, 1},
                                new int[]{1, 1, 0},
                                new int[]{0, 1, 1}
                        }
                )
        );
    }

    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int freshCnt = 0;
        int colLen = grid[0].length;
        int rowLen = grid.length;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (grid[i][j] == 1) {
                    freshCnt++;
                } else if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int cnt = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] rot = queue.poll();
                if (rot == null) {
                    continue;
                }
                int row = rot[0];
                int col = rot[1];
                freshCnt -= checkAndAdd(queue, grid, row + 1, col, rowLen, colLen);
                freshCnt -= checkAndAdd(queue, grid, row - 1, col, rowLen, colLen);
                freshCnt -= checkAndAdd(queue, grid, row, col + 1, rowLen, colLen);
                freshCnt -= checkAndAdd(queue, grid, row, col - 1, rowLen, colLen);
            }
            cnt += 1;
        }
        return freshCnt == 0 ? cnt : -1;
    }

    private int checkAndAdd(Queue<int[]> queue, int[][] grid, int row, int col, int rowLen, int colLen) {
        if (row >= rowLen || row < 0 || col < 0 || col >= colLen || grid[row][col] != 1) {
            return 0;
        }
        grid[row][col] = 2;
        queue.add(new int[]{row, col});
        return 1;
    }
}
