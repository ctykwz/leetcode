package com.icu.ctyk.array;

/**
 * https://leetcode-cn.com/problems/first-missing-positive/
 *
 * @author ctykwz on 2021-06-18 22:46
 */
public class FirstMissingPositive {


    public static void main(String[] args) {
        System.out.println(new FirstMissingPositive().firstMissingPositive(
                new int[]{3, 4, -1, 1})
        );
    }


    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // 位置i 存数字i+1
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] - nums[i] != 0) {
                swap(nums, nums[i] - 1, i);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - i != 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
