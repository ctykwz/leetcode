package com.icu.ctyk.array;

/**
 * https://leetcode-cn.com/problems/next-permutation/
 *
 * @author ctykwz on 2021-06-03 10:11
 */
public class NextPermutation {

    public static void main(String[] args) {
        new NextPermutation().nextPermutation(new int[]{1, 2, 3});
    }
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        // 从右侧找，找峰值左侧的第一个低点
        int left = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                left = i - 1;
                break;
            }
        }
        // 低点存在，说明不是单调递减的（从左到右）
        if (left >= 0) {
            // 从右侧找一个比左值大的值
            int right = nums.length - 1;
            while (right >= 0 && nums[right] <= nums[left]) {
                right--;
            }
            swap(nums, left, right);
        }
        reverse(nums, left + 1, nums.length - 1);
    }


    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
