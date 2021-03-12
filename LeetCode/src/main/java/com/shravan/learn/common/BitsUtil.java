package com.shravan.learn.common;

public class BitsUtil {
    // flip 0 to 1 and 1 to 0
    public static int invertBits(int n) {
        // Calculate number of bits of N-1;
        int x = (int) (Math.log(n) /
                Math.log(2));

        int m = 1 << x;

        m = m | m - 1;

        n = n ^ m;

        return n;
    }

    // count of bits (0 and 1) of the number
    public static int countBits(int n) {
        int count = 0;
        while (n != 0) {
            count += 1;
            n >>= 1;
        }
        return count;
    }

    // count of 1 bits of the number
    public static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }
}
