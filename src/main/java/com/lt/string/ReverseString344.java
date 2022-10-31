package com.lt.string;

public class ReverseString344 {
    public void reverseString(char[] s) {
        if (s == null || s.length == 1) return;
        int left = 0;
        int right = s.length - 1;
        //solution 1:
//        while (left < right) {
//            char tmp = s[left];
//            s[left] = s[right];
//            s[right] = tmp;
//            left++;
//            right--;
//        }
        //solution 2:
        while (left < right) {
            s[left] ^=s[right];
            s[right] ^= s[left];
            s[left] ^= s[right];
            left++;
            right--;
        }
    }
}
