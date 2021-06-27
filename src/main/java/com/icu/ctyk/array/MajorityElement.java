package com.icu.ctyk.array;

import java.util.Arrays;

/**
 * @author ctykwz on 2021-06-19 22:41
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        int candidate = 0;
        int cnt = 0;
        for (int num : nums) {
            if (cnt == 0) {
                candidate = num;
            }
            cnt += candidate == num ? 1 : -1;
        }
        return candidate;
    }
}
