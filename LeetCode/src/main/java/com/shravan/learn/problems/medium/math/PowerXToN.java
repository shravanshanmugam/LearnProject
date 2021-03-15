package com.shravan.learn.problems.medium.math;

public class PowerXToN {
    public double myPow(double x, int n) {
        if (n < 0) {
            // if n<0, then x^n = 1/x^-n
            return 1 / power(x, -n);
        }
        return power(x, n);
    }

    private double power(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        double a = power(x, n / 2);
        if (n % 2 != 0) {
            return a * a * x;
        }
        return a * a;

    }
}
