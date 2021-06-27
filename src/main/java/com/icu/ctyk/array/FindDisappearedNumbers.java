package com.icu.ctyk.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ctykwz on 2021-06-26 12:51
 */
public class FindDisappearedNumbers {

    public static void main(String[] args) {
        int[] val = new int[]{4, 3, 2, 7, 8, 1};
        System.out.println(new FindDisappearedNumbers().findDisappearedNumbers(val));
    }


    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[(nums[i] - 1) % nums.length] += nums.length;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < nums.length) {
                res.add(i + 1);
            }
        }
        return res;
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

}
