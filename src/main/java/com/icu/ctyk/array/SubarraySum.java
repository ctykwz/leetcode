package com.icu.ctyk.array;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/subarray-sum-equals-k/
 *
 * @author ctykwz on 2021-06-02 15:00
 */
public class SubarraySum {

    public static void main(String[] args) {
        System.out.println(new SubarraySum().subarraySum(new int[]{1, 1, 1}, 2));
    }

    public int subarraySum(int[] nums, int k) {
        if (nums == null) {
            return 0;
        }
        // 前缀：cnt
        Map<Integer, Integer> preSum = new HashMap<>();
        // 空串也是子串？
        preSum.put(0, 1);
        int sum = 0;
        int cnt = 0;
        for (int num : nums) {
            sum += num;
            if (preSum.containsKey(sum - k)) {
                cnt += preSum.getOrDefault(sum - k, 0);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        return cnt;
    }
}
