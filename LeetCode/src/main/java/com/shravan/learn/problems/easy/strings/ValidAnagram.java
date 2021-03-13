package com.shravan.learn.problems.easy.strings;

public class ValidAnagram {
    // two words are anagrams if their character frequency is same
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            counter[sChar - 'a']++;// increment for first string
            counter[tChar - 'a']--;// decrement for second string
        }

        // all values should be zero
        for (int i = 0; i < 26; i++) {
            if (counter[i] != 0) return false;
        }
        return true;
    }
}
