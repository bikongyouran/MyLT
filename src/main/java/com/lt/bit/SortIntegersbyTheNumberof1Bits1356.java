package com.lt.bit;

import java.util.Arrays;
import java.util.Comparator;

public class SortIntegersbyTheNumberof1Bits1356 {
    private int count(int a) {
        int count = 0;
        while (a != 0) {
            if ((a & 1) == 1) count++;
            a = a >> 1;
        }
        return count;
    }
    public int[] sortByBits(int[] arr) {
        return Arrays.stream(arr).boxed().sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int c1 = count(o1);
                int c2 = count(o2);
                return c1 == c2 ? Integer.compare(o1, o2) : Integer.compare(c1, c2);
            }
        }).mapToInt(Integer::intValue).toArray();
    }
}
