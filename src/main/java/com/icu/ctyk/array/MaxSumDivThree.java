package com.icu.ctyk.array;

/**
 * @author ctykwz on 2021-06-23 13:59
 */
public class MaxSumDivThree {

    public int maxSumDivThree(int[] nums) {
        int[] res = new int[3];
        int sum = 0;
        for (int num : nums) {
            int a = res[0] + num;
            int b = res[1] + num;
            int c = res[2] + num;
            res[a % 3] = Math.max(res[a % 3], a);
            res[b % 3] = Math.max(res[b % 3], b);
            res[c % 3] = Math.max(res[c % 3], c);
        }
        return res[0];
    }
}
