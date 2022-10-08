package com.lt;

public class FindFirstLastPosition34 {
    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        int left = findLeftBorder(nums, target);
        int right = findRightBorder(nums, target);
        return new int[]{left, right};
    }

    private static int findLeftBorder(int[] nums, int target) {
        int length = nums.length;
        int left = 0, right = length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else { // target =  mid
                right = mid - 1; // lock left border
            }
        }
        if (left >= length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    private static int findRightBorder(int[] nums, int target) {
        int length = nums.length;
        int left = 0, right = length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else { // target =  mid
                left = mid + 1; // lock right border
            }
        }
        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{};
        int target = 0;
        int[] res = searchRange(nums, target);
        System.out.println(res[0] + "," + res[1]);
    }
}
