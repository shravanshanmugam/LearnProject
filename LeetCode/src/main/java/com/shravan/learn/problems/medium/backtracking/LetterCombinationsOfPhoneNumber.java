package com.shravan.learn.problems.medium.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(String digits, int start, StringBuilder sb, List<String> result) {
        if (start == digits.length()) {
            result.add(sb.toString());
            return;
        }
        // take current digit and get corresponding letters
        int digit = Character.digit(digits.charAt(start), 10);
        String letters = map(digit);
        for (int i = 0; i < letters.toCharArray().length; i++) {
            char c = letters.charAt(i);
            sb.append(c);
            // for each letter, recurse over letters of the next digit
            backtrack(digits, start + 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private String map(int digit) {
        switch (digit) {
            case 2:
                return "abc";
            case 3:
                return "def";
            case 4:
                return "ghi";
            case 5:
                return "jkl";
            case 6:
                return "mno";
            case 7:
                return "pqrs";
            case 8:
                return "tuv";
            case 9:
                return "wxyz";
        }
        return null;
    }
}
