package com.lt.hashtable;

public class RansomNote383 {
    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] alpha = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            alpha[magazine.charAt(i) - 'a']++;
        }
        for (int j = 0; j < ransomNote.length(); j++) {
            alpha[ransomNote.charAt(j) - 'a']--;
        }
        for (int count : alpha) {
            if (count < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "ab";
        boolean res = canConstruct(ransomNote, magazine);
        System.out.println(res);
    }
}
