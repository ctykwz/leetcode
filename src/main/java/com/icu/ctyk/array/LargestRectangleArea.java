package com.icu.ctyk.array;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 *
 * @author ctykwz on 2021-06-19 15:48
 */
public class LargestRectangleArea {


    public static void main(String[] args) {
        System.out.println(new LargestRectangleArea().largestRectangleAreaV2(new int[]{2, 1, 5, 6, 2, 3}));
    }

    public int largestRectangleArea(int[] heights) {
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            int left = i;
            int right = i;
            while (left > 0) {
                if (heights[i] <= heights[left - 1]) {
                    left--;
                } else {
                    break;
                }
            }
            while (right < heights.length - 1) {
                if (heights[i] <= heights[right + 1]) {
                    right++;
                } else {
                    break;
                }
            }
            res = Math.max(res, (right - left + 1) * heights[i]);
        }
        return res;
    }

    public int largestRectangleAreaV2(int[] heights) {
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        Arrays.fill(right, heights.length);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            // 上个位置比当前位置高度大，说明栈里的元素有遇到右边界了（开始递减）
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                right[stack.pop()] = i;
            }
            // 如果还有元素，那么肯定只剩下比当前小的数据了，因为是顺次放入，所以左边界也有了 类似于当前元素高度属于峰值
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            res = Math.max(res, (right[i] - left[i] - 1) * heights[i]);
        }
        return res;
    }
}
