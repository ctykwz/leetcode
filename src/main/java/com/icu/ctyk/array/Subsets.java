package com.icu.ctyk.array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/subsets/
 *
 * @author ctykwz on 2021-06-18 10:11
 */
public class Subsets {

    public static void main(String[] args) {
        System.out.println(new Subsets().subsets(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> tmp, int[] nums, int start) {
        res.add(new ArrayList<>(tmp));
        if (start >= nums.length) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            tmp.add(nums[i]);
            dfs(res, tmp, nums, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}
