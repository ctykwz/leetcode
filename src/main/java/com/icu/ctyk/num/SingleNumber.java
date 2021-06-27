package com.icu.ctyk.num;

/**
 * @author ctykwz on 2021-06-05 21:37
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {
        int result = nums[0];
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}
