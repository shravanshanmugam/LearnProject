package com.shravan.learn.problems.easy.strings;

public class ValidPalindrome {
    public static void main(String[] args) {
        ValidPalindrome solution = new ValidPalindrome();
        boolean palindrome = solution.isPalindrome("A man, a plan, a canal: Panama");
        System.out.println("palindrome = " + palindrome);
    }

    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char first = s.charAt(i);
            // check if character is valid alpha numeric
            if (!Character.isLetterOrDigit(first)) {
                i++;
                continue;
            }
            char last = s.charAt(j);
            if (!Character.isLetterOrDigit(last)) {
                j--;
                continue;
            }
            // ignore case when comparing
            if (Character.toLowerCase(first) != Character.toLowerCase(last)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
