package com.icu.ctyk.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author ctykwz on 2021-06-06 10:57
 */
public class LongestConsecutive {

    public static void main(String[] args) {
        System.out.println(new LongestConsecutive().longestConsecutive(new int[]{-1, 1, 0}));
    }

    //找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> container = new HashSet<>();
        for (int num : nums) {
            container.add(num);
        }
        int res = 1;
        for (int num : nums) {
            if (container.contains(num - 1)) {
                // 非边界 不处理
                continue;
            }
            int len = 0;
            while (container.contains(num++)) {
                len++;
            }
            res = Math.max(res, len);
        }
        return res;
    }

}
