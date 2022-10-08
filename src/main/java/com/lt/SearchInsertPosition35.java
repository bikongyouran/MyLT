package com.lt;

public class SearchInsertPosition35 {
    public static int searchInsert(int[] nums, int target) {
        if (nums.length == 0) return 0;
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums =  new int[]{};
        int res = searchInsert(nums, 1);
        System.out.println(res);
    }
}
