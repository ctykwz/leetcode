package com.icu.ctyk.array;

import java.util.Arrays;

/**
 * @author ctykwz on 2021-06-07 21:18
 */
public class SearchRange {

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(new SearchRange().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8))
        );
    }


    public int[] searchRange(int[] nums, int target) {
        int left = findFirst(nums, target);
        if (left == -1) {
            return new int[]{-1, -1};
        }
        return new int[]{left, findLast(nums, target, left)};
    }

    private int findLast(int[] nums, int target, int left) {
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    private int findFirst(int[] nums, int target) {
        int right = nums.length - 1;
        int left = 0;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left] == target ? left : -1;
    }
}
