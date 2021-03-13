package com.shravan.learn.problems.easy.math;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    // use map for Roman to Integer conversion
    // go through string from back to front
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        char[] str = s.toCharArray();

        int decimal = 0;
        int prev = 0;

        for (int i = str.length - 1; i >= 0; i--) {
            if (map.get(str[i]) < prev) {
                decimal -= map.get(str[i]);
            } else {
                decimal += map.get(str[i]);
            }
            prev = map.get(str[i]);
        }
        return decimal;
    }
}
