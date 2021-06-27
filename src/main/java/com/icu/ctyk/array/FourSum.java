package com.icu.ctyk.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/4sum/
 *
 * @author ctykwz on 2021-06-27 12:20
 */
public class FourSum {

    public static void main(String[] args) {
        System.out.println(new FourSum().fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }


    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return nSum(nums, target, 4, 0);
    }

    private List<List<Integer>> nSum(int[] nums, int target, int n, int from) {
        if (nums.length < n) {
            return new ArrayList<>();
        }
        if (n == 2) {
            return twoSum(nums, target, from);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = from; i <= nums.length - n; ++i) {
            List<List<Integer>> sums = nSum(nums, target - nums[i], n - 1, i + 1);
            if (sums.size() != 0) {
                for (List<Integer> sum : sums) {
                    sum.add(nums[i]);
                }
                res.addAll(sums);
            }
            while (i < nums.length - n && nums[i] == nums[i + 1]) {
                i += 1;
            }
        }
        return res;
    }

    private List<List<Integer>> twoSum(int[] nums, int target, int from) {
        List<List<Integer>> res = new ArrayList<>();
        int right = nums.length - 1;
        int left = from;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                List<Integer> it = new ArrayList<>();
                it.add(nums[left]);
                it.add(nums[right]);
                res.add(it);
                while (left < right && nums[right] == nums[right - 1]) {
                    right = right - 1;
                }
                while (left < right && nums[left] == nums[left + 1]) {
                    left += 1;
                }
                left++;
                right--;
            } else if (sum > target) {
                while (left < right && nums[right] == nums[right - 1]) {
                    right = right - 1;
                }
                right = right - 1;
            } else {
                while (left < right && nums[left] == nums[left + 1]) {
                    left += 1;
                }
                left = left + 1;
            }
        }
        return res;
    }

}
