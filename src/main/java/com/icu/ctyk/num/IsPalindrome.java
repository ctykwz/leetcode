package com.icu.ctyk.num;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @author ctykwz on 2021-06-05 14:14
 */
public class IsPalindrome {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int result = 0;
        int cur = x;
        while (cur > 0) {
            int tmp = cur % 10;
            result = result * 10 + tmp;
            cur = cur / 10;
        }
        return x == result;
    }


    public static void main(String[] args) {
        System.out.println(new IsPalindrome().GetLeastNumbers_Solution(new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 0));
    }


    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (input == null || input.length < k) {
            return new ArrayList<>(0);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((num1, num2) -> num2 - num1);
        for (int num : input) {
            if (queue.size() < k) {
                queue.add(num);
                continue;
            }
            if (!queue.isEmpty()&&queue.peek() > num) {
                queue.poll();
                queue.add(num);
            }
        }
        return queue.isEmpty() ? new ArrayList<>() : new ArrayList<>(queue);
    }
}
