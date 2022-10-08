package com.lt;

public class MoveZeroes283 {
    public static void moveZeroes(int[] nums) {
        if (nums.length == 0) return;
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                int temp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = temp;
                slow ++;
            }
        }
    }
}
