package com.icu.ctyk.num;

/**
 * @author ctykwz on 2021-06-18 10:03
 */
public class MySqrt {

    public static void main(String[] args) {
        System.out.println(new MySqrt().mySqrt(8));
    }

    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid * mid > x) {
                right = mid - 1;
            } else {
                res = mid;
                left = mid + 1;
            }
        }
        return res;
    }
}
