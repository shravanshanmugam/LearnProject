package com.shravan.learn.problems.easy.strings;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        // take first string as prefix
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            // check if prefix is present in other strings
            while (strs[i].indexOf(prefix) != 0) {
                // reduce prefix length by 1 and check again
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }
}
