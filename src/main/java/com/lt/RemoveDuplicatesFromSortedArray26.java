package com.lt;

public class RemoveDuplicatesFromSortedArray26 {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int slow = 0;
        for (int fast = 1; fast < nums.length; fast ++) {
            if (nums[slow] != nums[fast]) {
                nums[slow + 1] = nums[fast];
                slow ++;
            }
        }
        return slow + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {0,0,1,1,1,2,2,3,3,4};
        int res = removeDuplicates(nums);
        System.out.println(res);
    }
}
