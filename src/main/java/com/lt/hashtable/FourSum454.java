package com.lt.hashtable;

import java.util.HashMap;
import java.util.Map;

public class FourSum454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        if (nums1 == null || nums2 == null || nums3 == null || nums4 == null) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                int sum = num1 + num2;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        int count = 0;
        for (int num3 : nums3) {
            for (int num4 : nums4) {
                int sum = num3 + num4;
                if (map.containsKey(0 - sum)) {
                    count += map.get(0 - sum);
                }
            }
        }
        return count;
    }
}
