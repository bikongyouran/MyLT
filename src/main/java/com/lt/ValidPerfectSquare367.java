package com.lt;

public class ValidPerfectSquare367 {
    public static boolean isPerfectSquare(int num) {
        int left = 1, right = num;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long)mid*mid == num) {
                return true;
            } else if ((long)mid*mid < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean res = isPerfectSquare(1);
        System.out.println(res);
    }
}
