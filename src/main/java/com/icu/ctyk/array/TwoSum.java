package com.icu.ctyk.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ctykwz on 2021-06-02 22:41
 */
public class TwoSum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TwoSum().twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

    public int[] twoSumV2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        Set<Integer> values = new HashSet<>();
        for (int num : nums) {
            int tmp = target - num;
            if (values.contains(tmp)) {
                return new int[]{num, tmp};
            }
            values.add(num);
        }
        return new int[]{};
    }

    //输入一个递增排序的数组
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] > target) {
                right--;
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                return new int[]{nums[left], nums[right]};
            }
        }
        return new int[]{};
    }

}
