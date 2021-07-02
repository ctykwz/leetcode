package com.icu.ctyk.array;

/**
 * https://leetcode-cn.com/problems/arithmetic-slices/
 *
 * @author ctykwz on 2021-07-02 11:13
 */
public class NumberOfArithmeticSlices {

    public static void main(String[] args) {
        System.out.println(new NumberOfArithmeticSlices().numberOfArithmeticSlices(new int[]{1, 2, 3, 4, 5, 6, 7}));
    }

    public int numberOfArithmeticSlices(int[] nums) {
        // 以i 结尾的等差数列的个数
        int[] dp = new int[nums.length];
        int cnt = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                // eg. 1,2,3,4,5   i=2时 有1,2,3 i=3的时候有1,2,3,4 和 2,3,4  以5结尾的有1,2,3,4,5 2,3,4,5 3,4,5 也就是i每增
                // 加一位 dp[i] 就相对上一个+1
                dp[i] = dp[i - 1] + 1;
                cnt = dp[i] + 1;
            }
        }
        return cnt;
    }
}
