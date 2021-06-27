package com.icu.ctyk.array;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/4sum-ii/
 * 四数组之和
 *
 * @author ctykwz on 2021-06-27 19:46
 */
public class FourSumCount {

    /**
     * 包里循环或者分组 类似于已知某一部分再求剩余部分
     */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> container = new HashMap<>();
        for (int i : nums1) {
            for (int j : nums2) {
                int sum = i + j;
                container.put(sum, container.getOrDefault(sum, 0) + 1);
            }
        }
        int cnt = 0;
        for (int i : nums3) {
            for (int j : nums4) {
                int sum = i + j;
                cnt += container.getOrDefault(-sum, 0);
            }
        }
        return cnt;
    }
}
