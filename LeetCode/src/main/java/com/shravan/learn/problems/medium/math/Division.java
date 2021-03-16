package com.shravan.learn.problems.medium.math;

public class Division {
    public static void main(String[] args) {
        Division solution = new Division();
        int divide = solution.divide(12345, 2);
        System.out.println("divide = " + divide);
    }

    // Basic solution but not efficient
    /*public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
        int result = 0;
        long x = Math.abs((long) dividend);
        long y = Math.abs((long) divisor);

        while (x >= y) {
            x -= y;
            result++;
        }
        return result * sign;
    }*/

    // divide without using division, multiplication or modulus operator
    // Repeated subtraction with power of 2 and bit manipulation
    // compute largest k for 2^k * y <= x, then subtract 2^k * y from x and add 2^k to the quotient
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
        int result = 0;
        int power = 32;
        long x = Math.abs((long) dividend);
        long y = Math.abs((long) divisor);

        while (x >= y) {
            while ((y << power) > x) {
                power--;
            }
            x -= y << power;
            result += 1 << power;
        }
        return result * sign;
    }
}
