package com.icu.ctyk.num;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/chou-shu-lcof/
 *
 * @author ctykwz on 2021-06-22 10:37
 */
public class NthUglyNumber {

    public int nthUglyNumberV1(int n) {
        int[] factor = new int[]{2, 3, 5};
        PriorityQueue<Long> queue = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        queue.offer(1L);
        set.add(1L);
        Long res = 0L;
        for (int i = 1; i <= n; i++) {
            Long cur = queue.poll();
            res = cur;
            for (int fac : factor) {
                Long next = cur * fac;
                if (set.add(next)) {
                    queue.offer(next);
                }
            }
        }
        return res.intValue();
    }

    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int fac2 = 1;
        int fac3 = 1;
        int fac5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[fac2] * 2;
            int num3 = dp[fac3] * 3;
            int num5 = dp[fac5] * 5;
            dp[i] = Math.min(num2, Math.min(num3, num5));
            if (num2 == dp[i]) {
                fac2++;
            }
            if (num3 == dp[i]) {
                fac3++;
            }
            if (num5 == dp[i]) {
                fac5++;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new NthUglyNumber().nthUglyNumber(10));
    }

}
