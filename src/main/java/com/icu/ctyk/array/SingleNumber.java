package com.icu.ctyk.array;

/**
 * @author ctykwz on 2021-06-10 21:43
 */
public class SingleNumber {

    public static void main(String[] args) {
        System.out.println(new SingleNumber().singleNumber(new int[]{30000, 500, 100, 30000, 100, 30000, 100}));
    }

    public int singleNumber(int[] nums) {
        int a = 0;
        int b = 0;
        for (int num : nums) {
            a = (a ^ num) & ~b;
            b = (b ^ num) & ~a;
        }
        return a;
    }

}
