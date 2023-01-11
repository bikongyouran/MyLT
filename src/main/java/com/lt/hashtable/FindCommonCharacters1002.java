package com.lt.hashtable;

import java.util.ArrayList;
import java.util.List;

public class FindCommonCharacters1002 {
    public List<String> commonChars(String[] words) {
        int[] list = new int[26];
        for (int i = 0; i < words[0].length(); i++) {
            String word = words[0];
            Character c = word.charAt(i);
            list[c - 'a']++;
        }
        for (int i = 1; i < words.length; i++) {
            int[] tmp = new int[26];
            for (int j = 0; j < words[i].length(); j++) {
                String word = words[i];
                Character c = word.charAt(j);
                tmp[c - 'a']++;
            }
            for (int k = 0; k < 26; k++) {
                list[k] = Math.min(list[k], tmp[k]);
            }
        }
        List<String> res = new ArrayList<>();
        for (int k = 0; k < 26; k++) {
            char c = (char) ('a' + k);
            int count = list[k];
            for (int i = 0; i < count; i++) {
                res.add(String.valueOf(c));
            }
        }
        return res;
    }
}
