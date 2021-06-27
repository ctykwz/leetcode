package com.icu.ctyk.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ctykwz on 2021-06-04 19:09
 */
public class NumRabbits {

    public static void main(String[] args) {
        System.out.println(new NumRabbits().numRabbits(new int[]{10, 10, 10}));
    }

    public int numRabbits(int[] answers) {
        //数组长度应该不会超过answers的个数
        Map<Integer, Integer> answerCounter = new HashMap<>();
        int result = 0;
        for (int answer : answers) {
            if (answerCounter.containsKey(answer) && answerCounter.get(answer) > 0) {
                answerCounter.put(answer, answerCounter.get(answer) - 1);
            } else {
                answerCounter.put(answer, answer);
                result += answer + 1;
            }
        }
        return result;
    }
}
