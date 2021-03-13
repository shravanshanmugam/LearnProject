package com.shravan.learn.problems.medium.strings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();
        int abcabcbb = solution.lengthOfLongestSubstring("abcabcbb");
        System.out.println("abcabcbb = " + abcabcbb);
        int bbbbb = solution.lengthOfLongestSubstring("bbbbb");
        System.out.println("bbbbb = " + bbbbb);
        int pwwkew = solution.lengthOfLongestSubstring("pwwkew");
        System.out.println("pwwkew = " + pwwkew);
        int tmmzuxt = solution.lengthOfLongestSubstring("tmmzuxt");
        System.out.println("tmmzuxt = " + tmmzuxt);
        int ckilbkd = solution.lengthOfLongestSubstring("ckilbkd");
        System.out.println("ckilbkd = " + ckilbkd);
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return 1;
        Map<Character, Integer> indexMap = new HashMap<>();
        char[] chars = s.toCharArray();
        int max = 0;
        int start = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (indexMap.containsKey(c)) {
                Integer index = indexMap.get(c);
                // if character already occurs, update start index
                if (start <= index)
                    start = index + 1;
            }
            // length = current index + 1 - start index
            max = Math.max(max, i + 1 - start);
            indexMap.put(c, i);
        }
        return max;
    }
}
