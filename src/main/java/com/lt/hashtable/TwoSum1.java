package com.lt.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        TwoSum1 in = new TwoSum1();
        int[] nums = new int[] {3,3};
        int target = 6;
        int[] res = in.twoSum(nums, target);
        System.out.println(Arrays.toString(res));
    }
}
