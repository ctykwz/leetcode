package com.icu.ctyk.array;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/partition-to-k-equal-sum-subsets/
 * 给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等
 * 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * 输出： True
 * 说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
 *
 * @author ctykwz on 2021-07-02 11:43
 */
public class CanPartitionKSubsets {

    public static void main(String[] args) {
        System.out.println(new CanPartitionKSubsets().canPartitionKSubsets(
                new int[]{18, 20, 39, 73, 96, 99, 101, 111, 114, 190, 207, 295, 471, 649, 700, 1037}
                , 4));
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        int target = sum / k;
        Arrays.sort(nums);
        if (nums[nums.length - 1] > target) {
            return false;
        }
        boolean[] visited = new boolean[nums.length];
        //和为i时是否能够划分成等和子集
        return anyMatch(visited, nums, k, target, 0, 0);
    }

    private boolean anyMatch(boolean[] visited, int[] nums, int k, int target, int sum, int start) {
        if (k == 0) {
            return true;
        }
        // 从0开始一一遍历寻找满足拆分的数据
        if (sum == target) {
            return anyMatch(visited, nums, k - 1, target, 0, 0);
        }
        for (int i = start; i < nums.length; i++) {
            if (visited[i] || sum + nums[i] > target) {
                continue;
            }
            visited[i] = true;
            if (anyMatch(visited, nums, k, target, sum + nums[i], i + 1)) {
                return true;
            }
            visited[i] = false;
        }
        return false;
    }
}
