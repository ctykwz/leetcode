package com.icu.ctyk.array;

/**
 * @author ctykwz on 2021-06-28 16:49
 */
public class LongestOnes {

    public static void main(String[] args) {
        System.out.println(new LongestOnes().longestOnes(
                new int[]{0, 0, 0, 1}, 4
        ));
    }

    public int longestOnes(int[] nums, int k) {
        int right = 0;
        int left = 0;
        int res = 0;
        int zero = k;
        while (right <= nums.length) {
            if (nums[right] == 0) {
                zero += 1;
            }
            while (zero > k) {
                if (nums[left] == 0) {
                    zero -= 1;
                }
                left += 1;
            }
            res = Math.max(res, right - left + 1);
            right += 1;
        }
        return res;
    }
}
