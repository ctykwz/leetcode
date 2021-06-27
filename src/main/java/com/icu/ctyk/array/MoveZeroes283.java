package com.icu.ctyk.array;

/**
 * @author ctykwz on 2021-06-20 12:06
 */
public class MoveZeroes283 {

    public static void main(String[] args) {
        new MoveZeroes283().moveZeroes(new int[]{0, 1, 0, 3, 12});
    }

    public void moveZeroes(int[] nums) {
        int zeroPos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, i, zeroPos);
                zeroPos++;
            }
        }
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
