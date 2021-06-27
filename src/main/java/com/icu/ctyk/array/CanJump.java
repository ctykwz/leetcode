package com.icu.ctyk.array;

/**
 * @author ctykwz on 2021-06-10 15:57
 */
public class CanJump {

    public static void main(String[] args) {
        System.out.println(new CanJump().canJump(new int[]{3, 2, 1, 0, 4}));
    }


    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        // 位置i 所能跳跃的最大距离
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            //i之前的最远只能到max
            if (i > max) {
                return false;
            }
            max = Math.max(max, nums[i] + i);
            // 当前最远能到的index
            if (max >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
