package com.lt.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) return res;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0 && nums[i] > target) return res;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length; j++) {
                // here should not use "returen res", otherwise will miss some result.
                // the reason is it is not the first circle!!
                if ((nums[j] + nums[i]) > 0 && (nums[j] + nums[i]) > target) break;
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    long sum = (long)nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (right > left && nums[left] == nums[left + 1]) left++;
                        while (right > left && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FourSum18 in = new FourSum18();
        int[] nums = new int[] {-3,-2,-1,0,0,1,2,3};
        int target = 0;
        List<List<Integer>> res = in.fourSum(nums, target);
        System.out.println(res);
    }
}
