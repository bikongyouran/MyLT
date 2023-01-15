package com.lt.simulate;

public class NextPermutation31 {
    public void nextPermutation(int[] nums) {
        //从右到左找尽量小的数和尽量大的数，交换
        int len = nums.length;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = len - 1; j > i; j--) {
                if (nums[i] < nums[j]) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                    reverse(nums, i + 1, len - 1);
                    return;
                }
            }
        }
        reverse(nums, 0, len - 1);
    }

    private void reverse(int[] nums, int begin, int end) {
        while (begin < end) {
            int temp = nums[begin];
            nums[begin] = nums[end];
            nums[end] = temp;
            begin++;
            end--;
        }
    }
}
