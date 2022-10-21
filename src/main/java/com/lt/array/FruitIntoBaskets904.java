package com.lt.array;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets904 {
    public static int totalFruit(int[] fruits) {
        int left = 0;
        int window = 0;
        Map<Integer, Integer> basket = new HashMap<Integer, Integer>();

        for (int right = 0; right < fruits.length; right++) {
            basket.put(fruits[right], basket.getOrDefault(fruits[right], 0) + 1);
            while (basket.size() > 2) {
                basket.put(fruits[left], basket.getOrDefault(fruits[left], 0) - 1);
                if (basket.get(fruits[left]) == 0) {
                    basket.remove(fruits[left]);
                }
                left++;
            }
            window = Math.max(window, right - left + 1);
        }
        return window;
    }

    public static void main(String[] args) {
        int[] fruits = new int[]{1,2,1};
        int res = totalFruit(fruits);
        System.out.println(res);
    }
}
