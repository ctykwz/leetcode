package com.icu.ctyk.num;

/**
 * https://leetcode-cn.com/problems/powx-n/
 *
 * @author ctykwz on 2021-06-19 15:25
 */
public class QuickMul {

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        return n > 0 ? calculate(x, n) : 1.0 / calculate(x, -n);
    }

    private double calculate(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double half = calculate(x, n / 2);
        return n % 2 == 0 ? half * half : half * half * x;
    }
}
