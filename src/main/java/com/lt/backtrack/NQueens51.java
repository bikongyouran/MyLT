package com.lt.backtrack;

import java.util.*;

public class NQueens51 {
    private List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] chessBoard = new char[n][n];
        for (char[] c : chessBoard) {
            Arrays.fill(c, '.');
        }
        backTrack(0, n, chessBoard);
        return res;
    }

    private void backTrack(int row, int n, char[][] chessBoard) {
        if (row == n) {
            res.add(array2List(chessBoard));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(row, col, n, chessBoard)) {
                chessBoard[row][col] = 'Q';
                backTrack(row + 1, n, chessBoard);
                chessBoard[row][col] = '.';
            }
        }
    }

    private List<String> array2List(char[][] chessBoard) {
        List<String> path = new ArrayList<>();
        for (char[] c : chessBoard) {
            path.add(String.copyValueOf(c));
        }
        return path;
    }

    private boolean isValid(int row, int col, int n, char[][] chessBoard) {
        for (int i = 0; i < row; i++) {//check col
            if (chessBoard[i][col] == 'Q') return false;
        }
        for (int i = row -1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessBoard[i][j] == 'Q') return false;
        }
        for (int i = row -1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (chessBoard[i][j] == 'Q') return false;
        }
        return true;
    }
}
