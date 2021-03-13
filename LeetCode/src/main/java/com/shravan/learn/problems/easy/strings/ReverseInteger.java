package com.shravan.learn.problems.easy.strings;

public class ReverseInteger {
    public static void main(String[] args) {
        ReverseInteger solution = new ReverseInteger();
        int reverse = solution.reverse(123456789);
        System.out.println("reverse = " + reverse);
    }

    public int reverse(int x) {
        if (x < 0) {
            return -reverseInt(-x);
        } else {
            return reverseInt(x);
        }
    }

    private int reverseInt(int x) {
        int newNo = 0;
        while (x > 0) {
            int digit = x % 10;
            if (newNo > Integer.MAX_VALUE / 10) return 0;
            newNo *= 10;
            newNo += digit;
            x = x / 10;
        }
        return newNo;
    }
}
