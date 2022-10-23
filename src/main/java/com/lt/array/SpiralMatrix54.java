package com.lt.array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix54 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return null;
        List<Integer> res = new ArrayList<>();
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
        int i,j;

        while (left <= right && top <= bottom) {
            for (j = left; j < right; j++) {//common case
                res.add(matrix[top][j]);
            }
            if (top == bottom && left < right) {//only 1 row
                res.add(matrix[top][j]);
            }
            for (i = top; i < bottom; i++) {//common case
                res.add(matrix[i][j]);
            }
            if (left == right && top < bottom) {//only 1 column
                res.add(matrix[i][left]);
            }
            if (left == right && top == bottom) {//middle value
                res.add(matrix[left][top]);
            }
            if (left < right && top < bottom) {//common case
                for (; j > left; j--) {
                    res.add(matrix[i][j]);
                }
                for (; i > top; i--) {
                    res.add(matrix[i][j]);
                }
            }

            left++;
            right--;
            top++;
            bottom--;
        }
        return res;
    }

    public static void main(String[] args) {
//        int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
//        int[][] matrix = new int[][]{{1,2,3,4}};

        List<Integer> res = spiralOrder(matrix);
        System.out.println(res);
    }
}
