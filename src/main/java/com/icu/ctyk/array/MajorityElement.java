package com.icu.ctyk.array;

/**
 * 摩尔投票法本事默认要求存在众数 不存在的话是要自己验证下的
 *
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


    /**
     * 默认不一定存在众数时
     */
    public int majorityElementV2(int[] nums) {
        int cnt = 0;
        int flag = -1;
        for (int num : nums) {
            if (cnt == 0) {
                flag = num;
            }
            cnt = flag == num ? cnt + 1 : cnt - 1;
        }
        cnt = 0;
        for (int num : nums) {
            if (flag == num) {
                cnt += 1;
            }
        }
        return cnt > nums.length / 2 ? flag : -1;
    }
}
