package com.icu.ctyk.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ctykwz on 2021-06-17 16:39
 */
public class Permute {

    public static void main(String[] args) {
        System.out.println(new Permute().permute(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>(0);
        }
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, nums, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] nums, int left) {
        if (left == nums.length) {
            res.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }
        for (int i = left; i < nums.length; i++) {
            swap(nums, left, i);
            dfs(res, nums, left + 1);
            swap(nums, left, i);
        }
    }

    private void swap(int[] nums, int left, int right) {
        if (left == right) {
            return;
        }
        int val = nums[left];
        nums[left] = nums[right];
        nums[right] = val;
    }

}
