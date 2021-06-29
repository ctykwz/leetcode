package com.icu.ctyk.array;

/**
 * @author ctykwz on 2021-06-29 19:27
 */
public class DeleteAndEarn {

    public static void main(String[] args) {
        System.out.println(
                new DeleteAndEarn().deleteAndEarn(new int[]{3, 4, 2})
        );
    }

    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int[] sum = new int[max + 1];
        for (int num : nums) {
            sum[num] += num;
        }
        // 获取去重累积集合
        return robV4(sum);
    }

    private int robV4(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            // 选了i 就不能选i-1和i+1
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }
}
