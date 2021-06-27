package com.icu.ctyk.array;

import java.util.Stack;

/**
 * @author ctykwz on 2021-06-10 22:03
 */
public class Find132pattern {

    public static void main(String[] args) {
        System.out.println(new Find132pattern().find132pattern(new int[]{1, 3, 2, 4, 5, 6, 7, 8, 9, 10}));
    }

    /**
     * 3,1,4,2
     * 2 入栈
     * 4>2 4入栈 k=2
     * 1<k ，此时因 现有栈里存在一个比k大的数据  ，而此时i处的数据又比k小，所以满足132的条件
     *
     * @param nums input
     * @return true/false
     */
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(nums[nums.length - 1]);
        int k = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < k) {
                return true;
            }
            // 放一个单调递减栈
            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                k = Math.max(stack.pop(), k);
            }
            stack.push(nums[i]);
        }
        return false;
    }
}
