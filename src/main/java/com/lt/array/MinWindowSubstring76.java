package com.lt.array;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring76 {
    public static String minWindow(String s, String t) {
        int left = 0, right = 0;
        int sLen = s.length();
        int tLen = t.length();
        Map<Character, Integer> neededChar = new HashMap<>();
        Map<Character, Integer> windowChar = new HashMap<>();
        for (int i = 0; i < tLen; i++) {
            neededChar.put(t.charAt(i), neededChar.getOrDefault(t.charAt(i), 0) + 1);
        }
        int valid = 0;
        int start = 0, len = Integer.MAX_VALUE;

        while (right < sLen) {
            char c = s.charAt(right);
            right++;
            if (neededChar.containsKey(c)) {
                windowChar.put(c, windowChar.getOrDefault(c, 0) + 1);
                if (windowChar.get(c).equals(neededChar.get(c))) {
                    valid++;
                }
            }

            while (valid == neededChar.size()) {
                //shrink window from left
                if (right - left + 1 < len) {
                    start = left;
                    len = right - left + 1;
                }
                char cl = s.charAt(left);
                left++;
                if (neededChar.containsKey(cl)) {
                    windowChar.put(cl, windowChar.get(cl) - 1);
                    if (windowChar.get(cl) < neededChar.get(cl)) {
                        valid--;
                    }
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len - 1);
    }

    public static void main(String[] args) {
        String s = "aaaaaaaaaaaabbbbbcdd";
        String t = "abcdd";
        String res = minWindow(s, t);
        System.out.println(res);
    }
}
