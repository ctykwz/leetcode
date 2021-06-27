package com.icu.ctyk.array;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author ctykwz on 2021-06-04 18:20
 */
public class DailyTemperatures {


    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                new DailyTemperatures().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}))
        );
    }

    // 最大栈
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        return result;
    }

}
