package com.lt.hashtable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return new int[0];

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> resSet = new HashSet<>();

        for (int num : nums1) {
            set1.add(num);
        }

        for (int num : nums2) {
            if (set1.contains(num)) {
                resSet.add(num);
            }
        }
        return resSet.stream().mapToInt(x -> x).toArray();
    }

    public static void main(String[] args) {
        IntersectionOfTwoArrays349 instance = new IntersectionOfTwoArrays349();
        int[] nums1 = new int[] {1,2,2,1};
        int[] nums2 = new int[] {2,2};
        int[] res = instance.intersection(nums1, nums2);
        System.out.println(Arrays.toString(res));
    }
}
