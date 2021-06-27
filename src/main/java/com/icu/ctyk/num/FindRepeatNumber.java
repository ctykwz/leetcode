package com.icu.ctyk.num;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ctykwz on 2021-06-03 22:29
 */
public class FindRepeatNumber {

    // 没提供默认值 认为数组非空且有重复值
    public int findRepeatNumber(int[] nums) {
        Set<Integer> tmp = new HashSet<>();
        for (int num : nums) {
            if (tmp.contains(num)) {
                return num;
            }
            tmp.add(num);
        }
        return -1;
    }

    // 没提供默认值 认为数组非空且有重复值 长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内 也就是说如果没有重复数据的话 index i =value i
    public int findRepeatNumberV2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i) {
                // 目的是要把数据放到“原”位置中
                continue;
            }
            if (nums[nums[i]] == i) {
                return i;
            }
            // 把 tmp 这个值放到tmp这个位置上去
            int tmp = nums[i];
            nums[i] = nums[tmp];
            nums[tmp] = tmp;
        }
        return -1;
    }
}
