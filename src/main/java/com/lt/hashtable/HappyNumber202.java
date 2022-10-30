package com.lt.hashtable;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber202 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int tmp = n;
        while (tmp != 1) {
            int sum = getSum(tmp);
            if (set.contains(sum)) return false;
            set.add(sum);
            tmp = sum;
        }
        return true;
    }

    private int getSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        HappyNumber202 in = new HappyNumber202();
        boolean res = in.isHappy(2);
        System.out.println(res);
    }

}
