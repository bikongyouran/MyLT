package com.lt.array;

import java.util.Arrays;

public class SquaresOfASortedArray977 {
    public static int[] sortedSquares(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];

        int start = 0, end = length - 1;
        int k = length - 1;
        while (end >= start) {
            if (nums[end] * nums[end] > nums[start] * nums[start]) {
                result[k--] = nums[end] * nums[end];
                end--;
            } else {
                result[k--] = nums[start] * nums[start];
                start++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {-4,-1,0,3,10};
        int[] res = sortedSquares(nums);
//        Arrays.stream(res).forEach(System.out::println);
        System.out.println(Arrays.toString(res));
    }
}
