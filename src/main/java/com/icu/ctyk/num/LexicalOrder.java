package com.icu.ctyk.num;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author ctykwz on 2021-06-17 20:19
 */
public class LexicalOrder {

    /**
     * 说法过于精辟
     * 字典序可以看成n叉树的前序遍历
     * 如n=13
     * 0                                                     val = 0
     * 0     1     2   3   4   5   6   7   8   9                              val*10+root.val
     * 0 1 2 3
     *
     * @param n n
     * @return value
     */
    public List<Integer> lexicalOrder(int n) {
        if (n <= 0) {
            return new ArrayList<>(0);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= n % 10; i++) {
            dfs(res, i, n);
        }
        return res;
    }

    private void dfs(List<Integer> res, int start, int max) {
        if (start > max) {
            return;
        }
        res.add(start);
        for (int i = 0; i <= 9; i++) {
            dfs(res, start * 10 + i, max);
        }
    }


    public static void main(String[] args) {
        System.out.println(new LexicalOrder().lexicalOrderV2(13));
    }

    /**
     * 栈处理
     * 9,8，7,6,5,4,3,2,1
     * 19 18,17.。。10
     * <p>
     * 比较慢
     *
     * @param n
     * @return
     */
    private List<Integer> lexicalOrderV2(int n) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        for (int i = Math.min(9, n); i > 0; i--) {
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            Integer value = stack.pop();
            res.add(value);
            int tmp = value * 10;
            for (int i = 9; i >= 0; i--) {
                int val = tmp + i;
                if (val <= n) {
                    stack.push(val);
                }
            }
        }
        return res;
    }
}
