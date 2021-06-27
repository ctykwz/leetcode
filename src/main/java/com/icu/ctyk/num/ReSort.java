package com.icu.ctyk.num;

/**
 * @author ctykwz on 2021-06-11 22:42
 */
public class ReSort {

    public static void main(String[] args) {
        new ReSort().reOrderArray(new int[]{1, 3, 4, 6, 5, 8, 9, 0, 1});
    }

    // 1 3 4 8 5 7 6   1 3
    public void reOrderArray(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int left = 0;
        int right = 0;
        while (right <= nums.length - 1 && left <= nums.length - 1) {
            while (left <= nums.length - 1 && nums[left] % 2 != 0) {
                left++;
            }
            while (right <= nums.length - 1 && (right <= left || nums[right] % 2 == 0)) {
                right++;
            }
            if (left > nums.length - 1 || right > nums.length - 1) {
                break;
            }
            int start = left;
            while (start < right) {
                swap(nums, start, right);
                start++;
            }
        }
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
