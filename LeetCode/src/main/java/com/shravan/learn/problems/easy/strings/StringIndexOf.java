package com.shravan.learn.problems.easy.strings;

public class StringIndexOf {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        if (haystack.length() < needle.length() || !haystack.contains(needle)) return -1;

        int x = 0;
        int y = 0;

        outer:
        for (int i = 0; i < haystack.length(); i++) {

            if (haystack.charAt(i) == needle.charAt(0)) {
                x = i + 1;
                y++;
                while (x < haystack.length() && y < needle.length()) {
                    if (haystack.charAt(x) == needle.charAt(y)) {
                        x++;
                        y++;
                    } else {
                        y = 0;
                        break;
                    }
                }
                if (y == needle.length()) {
                    break outer;
                }
            }
        }
        return x - y;

    }
}
