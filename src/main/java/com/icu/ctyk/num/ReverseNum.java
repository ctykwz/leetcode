package com.icu.ctyk.num;

/**
 * @author ctykwz on 2021-06-03 22:07
 */
public class ReverseNum {


    public static void main(String[] args) {
        System.out.println(new ReverseNum().reverse(1534236469));
    }

    public int reverse(int x) {
        int val = 0;
        int max = Integer.MAX_VALUE / 10;
        int min = Integer.MIN_VALUE / 10;
        do {
            // 因为后置逻辑要*10 所以要先提前处理下边界
            if (val < min || val > max) {
                return 0;
            }
            val = val * 10 + x % 10;
            x = x / 10;
        } while (x != 0);
        return val;
    }
}
