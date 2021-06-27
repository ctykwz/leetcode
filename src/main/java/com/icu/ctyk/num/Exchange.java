package com.icu.ctyk.num;

import java.util.Arrays;

/**
 * @author ctykwz on 2021-06-20 22:38
 */
public class Exchange {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Exchange().exchangeV2(
                new int[]{2, 3, 4, 5, 6}
        )));
    }

    public int[] exchangeV2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] % 2 != 0) {
                left++;
                continue;
            }
            if (nums[right] % 2 == 0) {
                right--;
                continue;
            }
            swap(nums, left, right);
        }
        return nums;
    }

    public int[] exchange(int[] nums) {
        int hold = 0;
        int faster = 0;
        while (faster < nums.length) {
            if (nums[faster] % 2 != 0) {
                swap(nums, faster, hold);
                hold++;
            }
            faster++;
        }
        return nums;
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
