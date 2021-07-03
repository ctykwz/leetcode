package com.icu.ctyk.array;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author ctykwz on 2021-07-03 19:42
 */
public class AsteroidCollision {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new AsteroidCollision().asteroidCollision(new int[]{-2, 1, 1, -1})));
    }

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            if (asteroid < 0 && !stack.isEmpty() && stack.peek() > 0) {
                int tmp;
                while (!stack.isEmpty() && stack.peek() > 0 && (tmp = stack.peek() + asteroid) <= 0) {
                    stack.pop();
                    if (tmp == 0) {
                        // 抵消了
                        break;
                    }
                    // 没抵消 但是没数据或者左侧为负了
                    if (stack.isEmpty() || stack.peek() < 0) {
                        stack.push(asteroid);
                        break;
                    }
                }
            } else {
                stack.push(asteroid);
            }
        }
        int[] res = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }
}
