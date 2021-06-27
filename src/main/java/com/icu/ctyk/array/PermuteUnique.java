package com.icu.ctyk.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://leetcode-cn.com/problems/permutations-ii/
 *
 * @author ctykwz on 2021-06-19 15:30
 */
public class PermuteUnique {


    public static void main(String[] args) {
        System.out.println(new PermuteUnique().permuteUnique(new int[]{1, 1, 3}));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, nums, 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, int[] nums, int start) {
        if (start >= nums.length) {
            result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }
        Set<Integer> container = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (container.contains(nums[i])) {
                continue;
            }
            container.add(nums[i]);
            swap(nums, i, start);
            dfs(result, nums, start + 1);
            swap(nums, i, start);
        }
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
