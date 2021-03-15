package com.shravan.learn.problems.medium.math;

public class Division {
    // divide without using division, multiplication or modulus operator
    public int divide(int dividend, int divisor) {
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
    }
}
