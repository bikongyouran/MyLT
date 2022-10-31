package com.lt.string;

public class ReverseStringTwo541 {
    public String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i += 2*k) {
            if (i + k <= ch.length) {
                reverse(ch, i, i + k - 1);
            } else {
                reverse(ch, i, ch.length - 1);
            }
        }
        return new String(ch);
    }

    private void reverse(char[] s, int start, int end) {
        while (start < end) {
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        ReverseStringTwo541 in = new ReverseStringTwo541();
        String s = "abcdefg";
        int k = 2;
        String res = in.reverseStr(s, k);
        System.out.println(res);
    }
}
