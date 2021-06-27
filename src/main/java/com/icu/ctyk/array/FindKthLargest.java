package com.icu.ctyk.array;

import java.util.Random;

/**
 * @author ctykwz on 2021-06-04 19:18
 */
public class FindKthLargest {

    public static void main(String[] args) {
        int[] val = new int[]{3, 2, 1, 5, 6, 4};
        System.out.println(new FindKthLargest().findKthLargest(val, val.length - 2));
    }

    public int findKthLargest(int[] nums, int k) {
        sort(nums, 0, nums.length - 1, nums.length - k);
        return nums[nums.length - k];
    }

    private void sort(int[] nums, int left, int right, int k) {
        if (left >= right) {
            return;
        }
        // pos左边的一定比右边的值小
        int pos = pos(nums, left, right);
        //  left  k   pos   right
        if (k < pos) {
            sort(nums, left, pos - 1, k);
        } else {
            // k 在 pos左边 ，只用排右边就行   left   pos  k   right
            sort(nums, pos + 1, right, k);
        }
    }

    private int pos(int[] nums, int left, int right) {
        int random = new Random().nextInt(right - left + 1) + left;
        swap(nums, random, right);
        int pos = left;
        for (int i = left; i < right; i++) {
            if (nums[i] < nums[right]) {
                swap(nums, pos++, i);
            }
        }
        swap(nums, pos, right);
        return pos;
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
