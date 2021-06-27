package com.icu.ctyk.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ctykwz on 2021-06-22 10:03
 */
public class SubsetsWithDup {

    public static void main(String[] args) {
        System.out.println(new SubsetsWithDup().subsetsWithDup(new int[]{1, 1, 2, 2}));
    }


    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(res, new ArrayList<>(), nums, 0);
        return res;
    }


    private void dfs(List<List<Integer>> res, List<Integer> container, int[] nums, int start) {
        res.add(new ArrayList<>(container));
        if (start >= nums.length) {
            return;
        }
        Set<Integer> tmp = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (tmp.contains(nums[i])) {
                continue;
            }
            tmp.add(nums[i]);
            container.add(nums[i]);
            dfs(res, container, nums, i + 1);
            container.remove(container.size() - 1);
        }
    }

}
