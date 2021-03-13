package com.shravan.learn.problems.easy.math;

public class PowerOfThree {
    // alternatively
    // 1. ((log10 n/ log10 3) % 1) == 0
    // 2. Max integer value = 2^31 - 1
    // max power of 3 = 3^19 = 1162261467
    // all numbers that can divide 3^19 is a power of 3
    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }

        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
        // alternatively
        // 1. return (Math.log10(n) / Math.log10(3)) % 1 == 0;
        // 2. return n > 0 && 1162261467 % n == 0;
    }
}
