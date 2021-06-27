package com.icu.ctyk.array;

/**
 * @author ctykwz on 2021-06-25 15:59
 */
public class IsValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        char[][] colValue = new char[9][9];
        char[][] rowValue = new char[9][9];
        char[][] brodValue = new char[9][9];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                char num = board[i][j];
                int index = num - '0' - 1;
                if (colValue[i][index] == num) {
                    return false;
                }
                if (rowValue[j][index] == num) {
                    return false;
                }
                int boxIndex = (i / 3) * 3 + j / 3;
                if (brodValue[boxIndex][index] == num) {
                    return false;
                }
                colValue[i][index] = num;
                rowValue[j][index] = num;
                brodValue[boxIndex][index] = num;
            }
        }
        return true;
    }
}
