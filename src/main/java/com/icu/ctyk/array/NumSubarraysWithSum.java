package com.icu.ctyk.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiyun on 2021-07-08 09:35
 */
public class NumSubarraysWithSum {

    public static void main(String[] args) {
        System.out.println(new NumSubarraysWithSum().numSubarraysWithSum(new int[]{1, 0, 1, 0, 1}, 2));
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> preMap = new HashMap<>();
        int res = 0;
        int sum = 0;
        for (int num : nums) {
            preMap.put(sum, preMap.getOrDefault(sum, 0) + 1);
            sum += num;
            res += preMap.getOrDefault(sum - goal, 0);
        }
        return res;
    }
}
