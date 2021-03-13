package com.shravan.learn.problems.easy.strings;

public class FirstUniqueCharacter {
    public int firstUniqChar(String s) {
        // create frequency map for the word
        int[] frequency = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            frequency[ch - 'a']++;
        }

        // find first letter in the word that has frequency = 1
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (frequency[ch - 'a'] == 1)
                return i;
        }
        return -1;
    }
}
