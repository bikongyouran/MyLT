package com.lt.array;

public class MinSizeSubarraySum209 {
    public static int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int window = 0;
        int result = Integer.MAX_VALUE;
        int sum = 0;

        for (int j = 0; j < nums.length; j++) {
            sum = sum + nums[j];
            while (sum >= target) {
                window = j - i + 1;
                result = result > window ? window : result;
                sum = sum -nums[i];
                i++;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,2,4,3};
        int target = 7;
        int res = minSubArrayLen(target, nums);
        System.out.println(res);
    }
}
