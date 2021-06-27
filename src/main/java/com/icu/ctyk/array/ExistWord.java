package com.icu.ctyk.array;

/**
 * @author ctykwz on 2021-06-18 08:48
 */
public class ExistWord {

    public static void main(String[] args) {
        System.out.println(
                new ExistWord().exist(
                        new char[][]{
                                new char[]{'A', 'B', 'C', 'D'},
                                new char[]{'S', 'F', 'C', 'S'},
                                new char[]{'A', 'D', 'E', 'E'}
                        },
                        "SEE"
                )
        );
    }

    /**
     * 岛屿面积
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }
        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (check(board, j, i, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean check(char[][] board, int top, int left, String word, int wordIndex) {
        if (word.length() == wordIndex) {
            return true;
        }
        if (top < 0 || left < 0 || left >= board[0].length || top >= board.length) {
            return false;
        }
        if (word.charAt(wordIndex) != board[top][left]) {
            return false;
        }
        char tmp = board[top][left];
        board[top][left] = '*';
        boolean res = check(board, top, left - 1, word, wordIndex + 1)
                || check(board, top, left + 1, word, wordIndex + 1)
                || check(board, top - 1, left, word, wordIndex + 1)
                || check(board, top + 1, left, word, wordIndex + 1);
        board[top][left] = tmp;
        return res;
    }
}
