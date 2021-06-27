package com.icu.ctyk.array;

/**
 * @author ctykwz on 2021-06-20 17:14
 */
public class FindCircleNum {

    // 岛屿面积系列 ？
    public int findCircleNum(int[][] isConnected) {
        int res = 0;
        int rowSize = isConnected.length;
        boolean[] visited = new boolean[rowSize];
        for (int i = 0; i < rowSize; i++) {
            if (!visited[i]) {
                res++;
                dfs(visited, isConnected, i, rowSize);
            }
        }
        return res;
    }

    // 遍历并标记所有 row点位及关联点位所能到达的点位
    private void dfs(boolean[] visited, int[][] nums, int row, int size) {
        if (row > size || row < 0) {
            return;
        }
        for (int j = 0; j < size; j++) {
            if (nums[row][j] != 0 && visited[j]) {
                visited[j] = true;
                dfs(visited, nums, j, size);
            }
        }
    }
}
