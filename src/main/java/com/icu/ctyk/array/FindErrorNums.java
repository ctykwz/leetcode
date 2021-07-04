package com.icu.ctyk.array;

import java.util.Arrays;

/**
 * @author ctykwz on 2021-07-04 08:55
 */
public class FindErrorNums {

    public static void main(String[] args) {
        int[] val = new int[]{1, 2, 3, 4, 2, 6};
        System.out.println(Arrays.toString(new FindErrorNums().findErrorNums(val)));
    }

    public int[] findErrorNums(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] - 1 != i && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 != i) {
                return new int[]{nums[i], i + 1};
            }
        }
        return new int[0];
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
