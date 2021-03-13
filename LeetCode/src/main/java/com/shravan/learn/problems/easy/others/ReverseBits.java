package com.shravan.learn.problems.easy.others;

public class ReverseBits {
    // n = 00111010
    // reverse = 01011100
    public int reverseBits(int n) {
        int reverse = 0;
        for (int i = 0; i < 32; i++) {
            reverse <<= 1;
            reverse |= (n & 1);
            n >>= 1;
        }
        return reverse;
    }
}
