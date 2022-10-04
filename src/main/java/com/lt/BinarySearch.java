package com.lt;

public class BinarySearch {
    public static int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int length = nums.length;
        int start = 0;
        int end = length -1;
        while (start <= end) {
            int mid = (end - start) / 2;
            if (nums[start + mid] == target) {
                return start + mid;
            } else if (nums[start + mid] < target) {
                start = start + mid + 1;
            } else {
                end = start + mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,3,5,9,12};
        int target = 2;
        int res = search(nums, target);
        System.out.println(res);

    }
}
