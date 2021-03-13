package com.shravan.learn.problems.easy.others;

public class NumberOf1Bits {
    // number of 1 bits in a number
    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }
}
