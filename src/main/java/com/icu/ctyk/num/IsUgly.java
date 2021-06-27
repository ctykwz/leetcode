package com.icu.ctyk.num;

/**
 * @author ctykwz on 2021-06-22 10:34
 */
public class IsUgly {

    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        int[] uglyFactor = new int[]{2, 3, 5};
        for (int ugly : uglyFactor) {
            while (n % ugly == 0) {
                n = n / ugly;
            }
        }
        return n == 1;
    }
}
