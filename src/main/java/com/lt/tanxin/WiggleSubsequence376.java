package com.lt.tanxin;

public class WiggleSubsequence376 {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null) return 0;
        if (nums.length == 1) return 1;
        if (nums.length == 2) {
            if(nums[1] != nums[0]) return 2;
            return 1;
        }

        int pre = 0;
        int cur = 0;
        int result = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            cur = nums[i + 1] - nums[i];
            if ((pre <= 0 && cur > 0) || (pre >= 0 && cur < 0)) {
                result++;
                pre = cur;
            }
        }
        return result;
    }
}
