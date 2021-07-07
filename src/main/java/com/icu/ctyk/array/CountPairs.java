package com.icu.ctyk.array;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/count-good-meals/
 *
 * @author xiyun on 2021-07-07 09:29
 */
public class CountPairs {

    public int countPairs(int[] deliciousness) {
        Map<Integer, Integer> preSum = new HashMap<>();
        int maxSum = 0;
        for (int num : deliciousness) {
            maxSum = Math.max(num, maxSum);
        }
        maxSum *= 2;
        int res = 0;
        for (int item : deliciousness) {
            for (int sum = 1; sum <= maxSum; sum *= 2) {
                // 类似前缀和，找两个值为2的幂次方的数
                int cnt = preSum.getOrDefault(sum - item, 0);
                res = (res + cnt) % 1000000007;
            }
            preSum.put(item, preSum.getOrDefault(item, 0) + 1);
        }
        return res;
    }
}
