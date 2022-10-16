package com.lt.array;

public class RemoveElement27 {
    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;

        int slow = 0;
        for (int fast = 0; fast < nums.length; fast ++) {
            if (val != nums[fast]) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,2,3};
        int val = 3;
        int res = removeElement(nums, val);
        System.out.println(res);
    }
}
