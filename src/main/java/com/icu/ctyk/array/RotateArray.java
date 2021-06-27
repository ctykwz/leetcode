package com.icu.ctyk.array;

import java.util.Arrays;

/**
 * @author ctykwz on 2021-06-20 19:29
 */
public class RotateArray {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        new RotateArray().rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k % nums.length == 0) {
            return;
        }
        int len = nums.length;
        revert(nums, 0, len - 1);
        k = k % len;
        revert(nums, 0, k - 1);
        revert(nums, k, len - 1);
    }

    private void revert(int[] nums, int from, int to) {
        while (from < to) {
            swap(nums, from, to);
            from++;
            to--;
        }
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
