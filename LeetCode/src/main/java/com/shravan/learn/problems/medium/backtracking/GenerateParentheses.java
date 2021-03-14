package com.shravan.learn.problems.medium.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        GenerateParentheses solution = new GenerateParentheses();
        List<String> strings = solution.generateParenthesis(3);
        System.out.println("strings = " + strings);
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(n, n, new StringBuilder(), result);
        return result;
    }

    private void backtrack(int m, int n, StringBuilder sb, List<String> result) {
        if (m > 0) {
            // if m == n, only open parentheses are possible
            if (m == n) {
                sb.append("(");
                backtrack(m - 1, n, sb, result);
                sb.deleteCharAt(sb.length() - 1);
            } else if (m < n) {
                // if m < n, both open and close parentheses are possible
                sb.append("(");
                backtrack(m - 1, n, sb, result);
                sb.deleteCharAt(sb.length() - 1);
                sb.append(")");
                backtrack(m, n - 1, sb, result);
                sb.deleteCharAt(sb.length() - 1);
            }
        } else {
            // m = 0, then only close parentheses is possible
            if (n > 0) {
                sb.append(")");
                backtrack(m, n - 1, sb, result);
                sb.deleteCharAt(sb.length() - 1);
            } else {
                result.add(sb.toString());
            }
        }
    }
}
