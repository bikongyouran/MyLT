package com.lt.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IntersectionOfTwoArrays350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return new int[0];

        Map<Integer, Integer> map1 = new HashMap<>();
        for (int num : nums1) {
            map1.put(num, map1.getOrDefault(num, 0) + 1);
        }

        int[] res = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            if (map1.containsKey(num)) {
                res[index++] = num;
                if (map1.get(num).equals(1)) {
                    map1.remove(num);
                } else {
                    map1.put(num, map1.get(num) - 1);
                }
            }
        }
        return Arrays.copyOfRange(res, 0, index);
    }

    public static void main(String[] args) {
        IntersectionOfTwoArrays350 instance = new IntersectionOfTwoArrays350();
        int[] nums1 = new int[] {1,2,2,1};
        int[] nums2 = new int[] {2,2};
        int[] res = instance.intersect(nums1, nums2);
        System.out.println(Arrays.toString(res));
    }
}
