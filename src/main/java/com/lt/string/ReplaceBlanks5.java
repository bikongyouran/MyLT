package com.lt.string;

public class ReplaceBlanks5 {
    public String replaceSpace(String s) {
        //%20
        if (s == null) return s;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                count++;
            }
        }
        int newLen = s.length() + count * 2;
        int oldIndex = s.length() - 1;
        int newIndex = newLen - 1;
        char[] newChar = new char[newLen];
        while (oldIndex >= 0) {
            if (s.charAt(oldIndex) == ' ') {
                newChar[newIndex--] = '0';
                newChar[newIndex--] = '2';
                newChar[newIndex--] = '%';
            } else {
                newChar[newIndex--] = s.charAt(oldIndex);
            }
            oldIndex--;
        }
        return new String(newChar);
    }
}
