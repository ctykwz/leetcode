package com.icu.ctyk.num;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ctykwz on 2021-06-27 19:54
 */
public class GenerateParenthesis {

    public static void main(String[] args) {
        System.out.println(new GenerateParenthesis().generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        dfs(res, new StringBuilder(), n, n);
        return res;
    }

    private void dfs(List<String> res, StringBuilder builder, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(builder.toString());
            return;
        }
        // 括号合法的条件是右括号数小于左括号
        if (left > right) {
            return;
        }
        if (left > 0) {
            dfs(res, builder.append("("), left - 1, right);
            builder.deleteCharAt(builder.length() - 1);
        }
        if (right > 0) {
            dfs(res, builder.append(")"), left, right - 1);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
