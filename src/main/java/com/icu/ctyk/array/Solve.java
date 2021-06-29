package com.icu.ctyk.array;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/surrounded-regions/
 *
 * @author ctykwz on 2021-06-29 16:18
 */
public class Solve {

    public static void main(String[] args) {
        char[][] inputs = new char[][]{
                new char[]{'X', 'X', 'X', 'X'},
                new char[]{'X', 'O', 'O', 'X'},
                new char[]{'X', 'X', 'O', 'X'},
                new char[]{'X', 'O', 'X', 'X'}
        };
        new Solve().solve(inputs);
        System.out.println(Arrays.deepToString(inputs));

    }

    // 题目的意思是从四周开始dfs，移除不能直达的 O
    public void solve(char[][] board) {
        int colLen = board[0].length;
        int rowLen = board.length;
        for (int i = 0; i < rowLen; i++) {
            dfs(board, i, 0, rowLen, colLen);
            dfs(board, i, colLen - 1, rowLen, colLen);
        }
        for (int i = 1; i < colLen - 1; i++) {
            dfs(board, 0, i, rowLen, colLen);
            dfs(board, rowLen - 1, i, rowLen, colLen);
        }
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (board[i][j] == ' ') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }

            }
        }
    }

    private void dfs(char[][] board, int row, int col, int rowLen, int colLen) {
        if (row >= rowLen || row < 0 || col < 0 || col >= colLen || board[row][col] != 'O') {
            return;
        }
        board[row][col] = ' ';
        dfs(board, row + 1, col, rowLen, colLen);
        dfs(board, row, col + 1, rowLen, colLen);
        dfs(board, row, col - 1, rowLen, colLen);
        dfs(board, row - 1, col, rowLen, colLen);
    }
}
