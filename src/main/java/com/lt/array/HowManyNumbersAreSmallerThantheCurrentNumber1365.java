package com.lt.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HowManyNumbersAreSmallerThantheCurrentNumber1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res = Arrays.copyOf(nums, nums.length);
        Arrays.sort(res);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < res.length; i++) {
            if (!map.containsKey(res[i])) {
                map.put(res[i], i);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            res[i] = map.get(nums[i]);
        }
        return res;
    }
}
