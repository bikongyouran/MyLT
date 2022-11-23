package com.lt.backtrack;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber17 {
    private List<String> res = new ArrayList<>();
    private String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) return res;
        if (digits.contains("1")) return res;

        StringBuilder sb = new StringBuilder();
        backTrack(digits, 0, sb);
        return res;
    }

    private void backTrack(String digits, int index, StringBuilder sb) {
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }
        String tmp = numString[digits.charAt(index) - '0'];
        int length = tmp.length();
        for (int i = 0; i < length; i++) {
            sb.append(tmp.charAt(i));
            backTrack(digits, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
