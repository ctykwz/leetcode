package com.icu.ctyk.array;

/**
 * @author ctykwz on 2021-06-20 11:16
 */
public class FindMin153 {

    public static void main(String[] args) {
        int[] val = new int[]{4, 0, 1, 2};
        System.out.println(new FindMin153().findMin(val));
    }

    public int findMin(int[] nums) {
        int right = nums.length - 1;
        int left = 0;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[left]) {
                left = mid + 1;
            } else {
                left++;
            }
        }
        return nums[left];
    }
}
