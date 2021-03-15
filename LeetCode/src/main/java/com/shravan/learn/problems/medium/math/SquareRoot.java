package com.shravan.learn.problems.medium.math;

public class SquareRoot {
    public static void main(String[] args) {
        SquareRoot solution = new SquareRoot();
        for (int i = 1; i <= 100; i++) {
            int sqrt = solution.mySqrt(i);
            System.out.println("i = " + i + ", sqrt = " + sqrt);
        }
    }

    public int mySqrt(int x) {
        int low = 1;
        int high = x;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int a = x / mid;
            if (a == mid) return mid;
            else if (a < mid) high = mid - 1;
            else low = mid + 1;
        }
        return low - 1;
    }
}
