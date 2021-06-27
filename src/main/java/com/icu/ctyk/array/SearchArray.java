package com.icu.ctyk.array;

/**
 * @author ctykwz on 2021-06-18 15:05
 */
public class SearchArray {

    public static void main(String[] args) {
        System.out.println(
                new SearchArray().search(new int[]{1, 0, 1, 1, 1}, 0)
        );
    }

    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[left] == nums[mid] && nums[right] == nums[mid]) {
                left++;
                right--;
            } else if (nums[mid] >= nums[left]) {
                if (nums[mid] > target && nums[left] <= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target < nums[nums.length - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }

            }
        }
        return false;
    }
}
