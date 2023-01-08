package com.lt.array;

public class ValidMountainArray941 {
    public boolean validMountainArray(int[] arr) {
        if (arr == null || arr.length < 3) return false;
        int left = 0;
        int right = arr.length - 1;
        while (left < arr.length - 1) {
            if (arr[left] < arr[left + 1]) {
                left++;
            } else if (arr[left] == arr[left + 1]) {
                return false;
            } else {
                break;
            }
        }
        while (right > 0) {
            if (arr[right] < arr[right - 1]) {
                right--;
            } else if (arr[right] == arr[right - 1]) {
                return false;
            } else {
                break;
            }
        }
        if ((left == right && left == 0) || (left == right && left == arr.length - 1)) return false;
        return left == right;
    }
}
