package com.lt.string;

import java.util.Arrays;

public class ReverseWordsInString151 {
    public String reverseWords(String s) {
        if (s == null) return s;
        char[] ch = s.toCharArray();
        ch = removeExtraSpace(ch);
        reverseString(ch, 0, ch.length - 1);
        int start = 0;
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == ' ') {
                reverseString(ch, start, i - 1);
                start = i + 1;
            } else if (i == ch.length - 1) {
                reverseString(ch, start, i);
            }
        }
        return new String(ch);
    }

    private char[] removeExtraSpace(char[] ch) {
        int fast = 0;
        int slow = 0;
        while (ch[fast] == ' ' && fast < ch.length) {
            fast++;
        }
        while (fast < ch.length) {
            if (ch[fast] == ' ' && ch[fast - 1] == ' ') {
                fast++;
            } else {
                ch[slow++] = ch[fast++];
            }
        }
        if (slow - 1 > 0 && ch[slow - 1] == ' ') {
            slow--;
        }
        char[] res = Arrays.copyOfRange(ch, 0, slow);
        return res;
    }

    private void reverseString(char[] ch, int start, int end) {
        while (start < end) {
            char tmp = ch[start];
            ch[start] = ch[end];
            ch[end] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        String s = " a good   example";
        ReverseWordsInString151 in = new ReverseWordsInString151();
        String res = in.reverseWords(s);
        System.out.println(res);
    }

}
