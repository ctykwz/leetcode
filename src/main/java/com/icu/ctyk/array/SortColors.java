package com.icu.ctyk.array;

import java.util.Arrays;

/**
 * @author ctykwz on 2021-06-23 22:36
 */
public class SortColors {

    public static void main(String[] args) {
        int[] nums = new int[]{0,2};
        new SortColors().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sortColors(int[] nums) {
        int zeroIndex = 0;
        int twoIndex = nums.length - 1;

        for (int i = 0; i <= twoIndex; i++) {
            while (twoIndex >= i && nums[i] == 2) {
                swap(nums, i, twoIndex);
                --twoIndex;
            }
            if (nums[i] == 0) {
                swap(nums, zeroIndex, i);
                ++zeroIndex;
            }
        }
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
