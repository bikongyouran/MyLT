package com.lt.hashtable;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings205 {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character si = s.charAt(i);
            Character ti = t.charAt(i);
            if (!map1.containsKey(si)) map1.put(si, ti);
            if (!map2.containsKey(ti)) map2.put(ti, si);
            if (map1.get(si) != ti || map2.get(ti) != si) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        IsomorphicStrings205 in = new IsomorphicStrings205();
        String s = "badc";
        String t = "baba";
        boolean res = in.isIsomorphic(s, t);
        System.out.println(res);
    }
}
