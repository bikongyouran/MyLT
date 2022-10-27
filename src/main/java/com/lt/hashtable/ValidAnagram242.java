package com.lt.hashtable;

public class ValidAnagram242 {
    public static boolean isAnagram(String s, String t) {
        int[] alpha = new int[26];
        int lengthS = s.length();
        int lengthT = t.length();
        for (int i = 0; i < lengthS; i++) {
            alpha[s.charAt(i) - 'a']++;
        }
        for (int j = 0; j < lengthT; j++) {
            alpha[t.charAt(j) - 'a']--;
        }
        for (int a = 0; a < 26; a++) {
            if (alpha[a] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "rat";
        String t = "car";
        boolean res = isAnagram(s, t);
        System.out.println(res);
    }
}
