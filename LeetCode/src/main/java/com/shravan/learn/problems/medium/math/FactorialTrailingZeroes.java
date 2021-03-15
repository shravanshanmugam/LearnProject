package com.shravan.learn.problems.medium.math;

public class FactorialTrailingZeroes {

    public static void main(String[] args) {
        FactorialTrailingZeroes solution = new FactorialTrailingZeroes();
        for (int i = 1; i <= 100; i++) {
            int trailingZeroes = solution.trailingZeroes(i);
            System.out.println("i = " + i + ", trailingZeroes = " + trailingZeroes);
        }
    }

    // no. of zeroes until n, n5 = (n/5) + no. of zeroes of n/5 if n/5 >= 5
    public int trailingZeroes(int n) {
        int n5 = 0;
        int temp = n;
        while (temp != 0) {
            int x = temp / 5;
            // number of 0s until n is n/5
            n5 += x;
            // if n/5 is greater than or equal to 5, then find number of 0s of n/5
            if (x >= 5)
                temp = x;
            else
                temp = 0;
        }
        return n5;
    }




    /*public int trailingZeroes(int n) {
        int count = 0;
        int temp = n;
        while (temp != 0) {
            int val = temp / 5;
            count = count + val;
            if (val >= 5)
                temp = val;
            else
                temp = 0;
        }
        return count;
    }*/

    private int findNumberOfFives(int x) {
        if (x % 5 != 0) return 0;
        return 1 + findNumberOfFives(x / 5);
    }
}
