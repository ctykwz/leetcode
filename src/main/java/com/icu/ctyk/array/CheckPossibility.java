package com.icu.ctyk.array;

/**
 * @author ctykwz on 2021-06-29 17:22
 */
public class CheckPossibility {

    public boolean checkPossibility(int[] nums) {
        int right = 0;
        int cnt = 0;
        while (right < nums.length - 1) {
            // 非递减
            if (nums[right] > nums[right + 1]) {
                cnt += 1;
                if (cnt > 1) {
                    return false;
                }
                if (right != 0) {
                    if (nums[right - 1] > nums[right + 1]) {
                        nums[right + 1] = nums[right];
                    } else if (nums[right - 1] < nums[right + 1]) {
                        nums[right] = nums[right + 1];
                    }
                }
            }
            right += 1;
        }
        return true;
    }

}
