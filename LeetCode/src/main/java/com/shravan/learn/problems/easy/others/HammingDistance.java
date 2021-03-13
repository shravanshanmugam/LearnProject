package com.shravan.learn.problems.easy.others;

import com.shravan.learn.common.BitsUtil;

public class HammingDistance {
    public static void main(String[] args) {
        HammingDistance solution = new HammingDistance();
        int hammingDistance = solution.hammingDistance(1, 2);
        System.out.println("hammingDistance = " + hammingDistance);
    }

    //    The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
    // 1   (0 0 0 1)
    // 4   (0 1 0 0)
    // Hamming distance = 2
    // count of different bits => count of set bits of x^y
    public int hammingDistance(int x, int y) {
        return BitsUtil.countSetBits(x ^ y);
    }
}
