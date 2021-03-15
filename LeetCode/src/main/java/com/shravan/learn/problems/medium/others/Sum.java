package com.shravan.learn.problems.medium.others;

public class Sum {
    // add without using + or - operator

    /**
     * Example
     * x = 7, y = 3, x+y = 10
     * x -> 111
     * y -> 011
     * x+y -> 1010
     * x^y -> 100 -> x
     * x&y -> 011
     * 2*(x&y) -> 110 -> y
     * x^y -> 010 -> x
     * x&y -> 100
     * 2*(x&y) -> 1000 -> y
     * x^y -> 1010 -> x = result
     * x&y -> 0000
     * 2*(x&y) -> 0000 -> y = 0
     */
    // sum(x,y) = sum(x^y,2*(x&y)) until y = 0
    public int getSum(int x, int y) {
        if (y == 0) return x;
        return getSum(x ^ y, (x & y) << 1);
    }

    // Iterative Solution - Same method
    /*public int getSum(int x, int y) {
        // Iterate till there is no carry
        while (y != 0) {
            // carry now contains common
            // set bits of x and y
            int carry = x & y;

            // Sum of bits of x and
            // y where at least one
            // of the bits is not set
            x = x ^ y;

            // Carry is shifted by
            // one so that adding it
            // to x gives the required sum
            y = carry << 1;
        }
        return x;
    }*/
}
