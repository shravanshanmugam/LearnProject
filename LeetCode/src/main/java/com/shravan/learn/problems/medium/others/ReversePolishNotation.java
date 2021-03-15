package com.shravan.learn.problems.medium.others;

import java.util.Stack;

public class ReversePolishNotation {
    // ["2","1","+","3","*"] => ((2 + 1) * 3) = 9
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int len = tokens.length;
        for (int i = 0; i < len; i++) {
            if (tokens[i].equals("+")) {
                int val1 = stack.pop();
                int val2 = stack.pop();
                stack.push(val1 + val2);
            } else if (tokens[i].equals("-")) {
                int val1 = stack.pop();
                int val2 = stack.pop();
                stack.push(val2 - val1);
            } else if (tokens[i].equals("*")) {
                int val1 = stack.pop();
                int val2 = stack.pop();
                stack.push(val1 * val2);
            } else if (tokens[i].equals("/")) {
                int val1 = stack.pop();
                int val2 = stack.pop();
                stack.push(val2 / val1);
            } else {
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.peek();
    }
}
