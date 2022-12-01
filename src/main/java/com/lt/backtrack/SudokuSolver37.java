package com.lt.backtrack;

public class SudokuSolver37 {
    public void solveSudoku(char[][] board) {
        backTrack(board);
    }

    private boolean backTrack(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') continue;
                for (char k = '1'; k <='9'; k++) {
                    if (isValid(i, j, k, board)) {
                        board[i][j] = k;
                        boolean res = backTrack(board);
                        if (res) return true;
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }

    private boolean isValid(int row, int col, char val, char[][] board){
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == val) return false;
        }
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == val) return false;
        }
        int startRow = (row/3) * 3;
        int startCol = (col/3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == val) return false;
            }
        }
        return true;
    }
}
