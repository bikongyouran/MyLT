package com.lt.array;

public class Sqrt69 {
    public static int mySqrt(int x) {
        if (x < 0) return -1;
        if (x == 0) return 0;
        int left = 1, right = x;
        int res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long)mid * mid <= x) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int x = 1;
        int res = mySqrt(x);
        System.out.println(res);
    }
}
