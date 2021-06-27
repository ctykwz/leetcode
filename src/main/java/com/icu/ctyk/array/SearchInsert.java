package com.icu.ctyk.array;

/**
 * @author ctykwz on 2021-06-20 14:36
 */
public class SearchInsert {

    public static void main(String[] args) {
        System.out.println(
                new SearchInsert().searchInsert(new int[]{1, 3, 5, 6}, 2)
        );
    }

    public int searchInsert(int[] nums, int target) {
        int right = nums.length - 1;
        int left = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
