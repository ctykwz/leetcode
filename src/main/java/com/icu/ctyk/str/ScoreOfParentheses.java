package com.icu.ctyk.str;

import java.util.Stack;

/**
 * (((()())))
 * 0
 * 0 0
 * 0 0 0
 * 0 0 0 0
 * 0 0 0 0 1
 * 0 0 0 0 1 0
 * 0 0 0 2
 * 0 0 4topKFrequent
 * 0 8
 * 16
 *
 * @author ctykwz on 2021-06-25 20:59
 */
public class ScoreOfParentheses {

    public int scoreOfParentheses(String s) {
        Stack<Integer> score = new Stack<>();
        score.push(0);
        for (char zChar : s.toCharArray()) {
            if (zChar == '(') {
                score.push(0);
            } else {
                int pre = score.pop();
                int prePre = score.pop();
                int value = Math.max(2 * (pre), 1) + prePre;
                score.push(value);
            }
        }
        return score.pop();
    }
}
