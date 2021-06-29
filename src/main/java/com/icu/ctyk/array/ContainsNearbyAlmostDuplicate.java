package com.icu.ctyk.array;

import java.util.TreeSet;

/**
 * @author ctykwz on 2021-06-29 11:41
 */
public class ContainsNearbyAlmostDuplicate {

    // -231 <= nums[i] <= 231 - 1
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // 构建一个从 i-t 到 i+t的有序集合 方便数据查询
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long celling = set.ceiling((long) nums[i] - (long) t);
            // 存在 nums[i]-nums[t] ~ nums[i]+nums[t] 满足条件
            if (celling != null && celling <= (long) nums[i] + (long) t) {
                return true;
            }
            set.add((long) nums[i]);
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }
}
