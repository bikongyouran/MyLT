package com.lt.tanxin;

public class SplitaStringinBalancedStrings1221 {
    public int balancedStringSplit(String s) {
        int countR = 0;
        int countL = 0;
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') countL++;
            if (s.charAt(i) == 'R') countR++;
            if (countL == countR) {
                total++;
                countL = 0;
                countR = 0;
            }
        }
        return total;
    }
}
