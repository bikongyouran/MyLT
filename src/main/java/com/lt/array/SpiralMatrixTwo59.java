package com.lt.array;

import java.util.Arrays;

public class SpiralMatrixTwo59 {
    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int loop = 0;
        int start = 0;
        int count = 1;
        int i, j;

        //left close, right open
        while (loop < n/2) {
            for (j = start; j < n - loop - 1; j++) {
                res[start][j] = count++;
            }
            for (i = start; i < n - loop - 1; i++) {
                res[i][j] = count++;
            }
            for (; j > loop; j--) {
                res[i][j] = count++;
            }
            for (; i > loop; i--) {
                res[i][j] = count++;
            }
            loop++;
            start++;
        }
        if (n % 2 == 1) {
            res[start][start] = count;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 1;
        int[][] res = generateMatrix(n);
        for (int[] arr: res) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
