package com.icu.ctyk.array;

/**
 * @author ctykwz on 2021-06-20 21:26
 */
public class MovingCount {


    public static void main(String[] args) {
        System.out.println(new MovingCount().movingCount(16, 8, 4));
    }


    public int movingCount(int m, int n, int k) {
        return dfs(m, n, k, 0, 0, new boolean[m][n]);
    }

    private int dfs(int m, int n, int k, int row, int col, boolean[][] visit) {
        if (row >= m || row < 0 || col < 0 || col >= n) {
            return 0;
        }
        if (visit[row][col]) {
            return 0;
        }
        visit[row][col] = true;
        if (sum(col) + sum(row) > k) {
            System.out.println(row + "\t" + col);
            return 0;
        }
        return 1 + dfs(m, n, k, row + 1, col, visit) + dfs(m, n, k, row - 1, col, visit)
                + dfs(m, n, k, row, col + 1, visit) + dfs(m, n, k, row, col - 1, visit);
    }

    private int sum(int value) {
        int res = 0;
        while (value > 0) {
            res += value % 10;
            value = value / 10;
        }
        return res;
    }
}
