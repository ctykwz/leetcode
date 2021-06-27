package com.icu.ctyk.num;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ctykwz on 2021-06-26 13:48
 */
public class FindDuplicates {

    public static void main(String[] args) {
        System.out.println(new FindDuplicates().findDuplicates(
                new int[]{3, 11, 8, 16, 4, 15, 4, 17, 14, 14, 6, 6, 2, 8, 3, 12, 15, 20, 20, 5}
        ));
    }

    public List<Integer> findDuplicates(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[nums[i] - 1] != nums[i]) {
                swap(nums, nums[i] - 1, i);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 != i && nums[nums[i] - 1] == nums[i]) {
                res.add(nums[i]);
            }
        }
        return res;
    }

    private void swap(int[] nums, int left, int right) {
        int val = nums[left];
        nums[left] = nums[right];
        nums[right] = val;
    }
}
