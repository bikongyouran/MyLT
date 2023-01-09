package com.lt.array;

public class UniqueNumberofOccurrences1207 {
    public boolean uniqueOccurrences(int[] arr) {
        int[] count = new int[2001];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] + 1000]++;
        }
        boolean[] res = new boolean[1001];
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                if (res[count[i]]) return false;
                else res[count[i]] = true;
            }
        }
        return true;
    }
}
