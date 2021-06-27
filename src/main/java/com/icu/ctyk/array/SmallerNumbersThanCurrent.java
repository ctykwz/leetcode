package com.icu.ctyk.array;

import java.util.Arrays;

/**
 * @author ctykwz on 2021-06-12 15:16
 */
public class SmallerNumbersThanCurrent {

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(new SmallerNumbersThanCurrent().smallerNumbersThanCurrent(new int[]{8, 1, 2, 2, 3}))
        );
    }

    public int[] smallerNumbersThanCurrent(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        //0<= num[i] <= 100
        int[] cnt = new int[101];
        for (int num : nums) {
            cnt[num] += 1;
        }
        for (int i = 0; i < cnt.length - 1; i++) {
            cnt[i + 1] += cnt[i];
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i] == 0 ? 0 : cnt[nums[i] - 1];
        }
        return res;
    }
}
