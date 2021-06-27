package com.icu.ctyk.num;

/**
 * @author ctykwz on 2021-06-22 11:31
 */
public class JudgeSquareSum {

    public boolean judgeSquareSum(int c) {
        int right = (int) Math.sqrt(c);
        int left = 0;
        while (left <= right) {
            int num = left * left + right * right;
            if (num == c) {
                return true;
            }
            if (num > c) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }
}
