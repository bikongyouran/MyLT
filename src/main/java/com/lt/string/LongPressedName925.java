package com.lt.string;

public class LongPressedName925 {
    public boolean isLongPressedName(String name, String typed) {
        int ln = name.length();
        int lt = typed.length();
        int i = 1;
        int j = 1;
        if (name.charAt(0) != typed.charAt(0)) return false;
        while (i < ln && j < lt) {
            if (name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (name.charAt(i) != typed.charAt(j) && name.charAt(i - 1) == typed.charAt(j)) {
                j++;
            } else {
                return false;
            }
        }
        if (j == lt && i < ln) return false;
        if (i == ln && j < lt) {
            for (int k = j; k < lt; k++) {
                if (typed.charAt(k) != name.charAt(ln - 1)) return false;
            }
        }
        return true;
    }
}
