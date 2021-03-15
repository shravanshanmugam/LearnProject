package com.shravan.learn.problems.medium.math;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    /**
     * Starting with any positive integer, replace the number by the sum of the squares of its digits.
     * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
     * Those numbers for which this process ends in 1 are happy.
     */
    private Set<Integer> visited = new HashSet<>();

    public static void main(String[] args) {
        HappyNumber solution = new HappyNumber();
        boolean happy19 = solution.isHappy(19);
        System.out.println("happy19 = " + happy19);
    }

    public boolean isHappy(int n) {
        // if n = 1, then happy number
        if (n == 1) return true;
        // if already visited, then not happy number
        if (visited.contains(n)) return false;
        int sum = 0;
        visited.add(n);
        // take out the digits and calculate sum of squares of digits
        while (n > 0) {
            int rem = n % 10;
            sum += rem * rem;
            n /= 10;
        }
        // check if new number is happy number
        return isHappy(sum);
    }
}
