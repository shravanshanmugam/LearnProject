package com.shravan.learn.problems.medium.strings;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();
        String bb = solution.longestPalindrome("bb");
        System.out.println("bb = " + bb);
        String abcdedcba = solution.longestPalindrome("abcdedcba");
        System.out.println("abcdedcba = " + abcdedcba);
        String abcdeedcba = solution.longestPalindrome("abcdeedcba");
        System.out.println("abcdeedcba = " + abcdeedcba);
        String bcadae = solution.longestPalindrome("bcadae");
        System.out.println("bcadae = " + bcadae);
        String babad = solution.longestPalindrome("babad");
        System.out.println("babad = " + babad);
        String cbbd = solution.longestPalindrome("cbbd");
        System.out.println("cbbd = " + cbbd);
        String a = solution.longestPalindrome("a");
        System.out.println("a = " + a);
        String ac = solution.longestPalindrome("ac");
        System.out.println("ac = " + ac);
        String aacabdkacaa = solution.longestPalindrome("aacabdkacaa");
        System.out.println("aacabdkacaa = " + aacabdkacaa);
        String babaddtattarrattatddetartrateedredividerb = solution.longestPalindrome("babaddtattarrattatddetartrateedredividerb");
        System.out.println("babaddtattarrattatddetartrateedredividerb = " + babaddtattarrattatddetartrateedredividerb);
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int oddLength = expandAroundCenter(s, i, i);
            int evenLength = expandAroundCenter(s, i, i + 1);
            int len = Math.max(oddLength, evenLength);
            // calculate start and end index based on string length and current index
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int low, int high) {
        while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
            low--;
            high++;
        }
        return high - low - 1;
    }

    /*public String longestPalindrome(String s) {
        for (int j = s.length(); j > 0; j--) {
            for (int i = 0; i + j <= s.length(); i++) {
                String substring = s.substring(i, i+j);
                if (isPalindrome(substring))
                    return substring;
            }
        }
        return null;
    }

    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char first = s.charAt(i);
            char last = s.charAt(j);
            if (first != last) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }*/
}
