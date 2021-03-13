package com.shravan.learn.problems.medium.strings;

import java.util.*;

public class GroupAnagrams {
    // characters of anagram when sorted have same string
    // alternatively, anagrams have same character frequency
    // 1. create a key out of character frequency
    // key = (count of a),(count of b),(count of c),...,(count of z)
    // 2. group by this key
    // 3. return list of values
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] characters = str.toCharArray();
            Arrays.sort(characters);
            String sorted = String.valueOf(characters);
            List<String> anagrams = map.getOrDefault(sorted, new ArrayList<>());
            anagrams.add(str);
            map.put(sorted, anagrams);
        }

        return new ArrayList<>(map.values());
    }
}
