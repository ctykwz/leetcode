package com.icu.ctyk.array;

import java.util.Arrays;

/**
 * @author ctykwz on 2021-07-03 16:48
 */
public class TriangleNumber {

    // a+b>c a+c>b c+b>a
    public int triangleNumberV2(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        // a
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] <= 0) {
                continue;
            }
            // c
            int right = i + 2;
            //b 需要找a+b>c的数量
            for (int j = i + 1; j < nums.length - 1; j++) {
                int target = nums[i] + nums[j];
                while (right < nums.length && target > nums[right]) {
                    right += 1;
                }
                res += right - j - 1;
            }
        }
        return res;
    }

    // a+b>c a+c>b c+b>a
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        // a
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] <= 0) {
                continue;
            }
            // c
            int right = i + 2;
            //b 需要找a+b>c的数量
            for (int j = i + 1; j < nums.length - 1; j++) {
                right = findMaxRight(nums, right, nums.length - 1, nums[i] + nums[j]);
                res += right - j - 1;
            }
        }
        return res;
    }

    private int findMaxRight(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 找 < target的index
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}
