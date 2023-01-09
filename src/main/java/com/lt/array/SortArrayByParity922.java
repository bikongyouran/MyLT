package com.lt.array;

public class SortArrayByParity922 {
    public int[] sortArrayByParityII(int[] nums) {
        int oddIndex = 1;
        for (int i = 0; i < nums.length; i += 2) {
            if (nums[i] % 2 == 1) {//偶数位是奇数
                while (nums[oddIndex] % 2 == 1) oddIndex += 2;
                int tmp = nums[oddIndex];
                nums[oddIndex] = nums[i];
                nums[i] = tmp;
            }
        }
        return nums;
    }
}
