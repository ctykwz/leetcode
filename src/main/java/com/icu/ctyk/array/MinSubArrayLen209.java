package com.icu.ctyk.array;

/**
 * @author ctykwz on 2021-06-20 13:55
 */
public class MinSubArrayLen209 {

    public static void main(String[] args) {
        System.out.println(new MinSubArrayLen209().minSubArrayLen(4, new int[]{1, 4, 4}));
    }

    public int minSubArrayLen(int target, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int slow = 0;
        int fast = 0;
        int sum = nums[0];
        int res = nums.length + 1;
        while (fast < nums.length && slow <= fast) {
            if (slow == fast && nums[slow] == target) {
                return 1;
            } else if (target > sum) {
                fast++;
                if (fast < nums.length) {
                    sum += nums[fast];
                }
            }
            if (target <= sum) {
                res = Math.min(res, fast - slow + 1);
                sum -= nums[slow];
                slow++;
            }
        }
        return res > nums.length ? 0 : res;
    }

    public int minSubArrayLenV2(int target, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        int fast = 0;
        int slow = 0;
        int sum = 0;
        while (slow < nums.length) {
            sum += nums[slow];
            while (sum >= target) {
                res = Math.min(res, fast - slow + 1);
                sum -= nums[slow];
                slow++;
            }
            fast++;
        }
        return res > nums.length ? 0 : res;
    }
}
