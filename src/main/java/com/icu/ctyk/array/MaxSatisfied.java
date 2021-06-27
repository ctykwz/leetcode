package com.icu.ctyk.array;

/**
 * @author ctykwz on 2021-06-26 15:35
 */
public class MaxSatisfied {
    public static void main(String[] args) {
        System.out.println(new MaxSatisfied().maxSatisfied(
                new int[]{2,6,6,9},
                new int[]{0,0,1,1},
                1
        ));
    }

    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int res = 0;
        for (int i = 0; i < grumpy.length; i++) {
            if (grumpy[i] == 0) {
                res += customers[i];
                customers[i] = 0;
            }
        }
        int max = 0;
        int tmp = 0;
        for (int i = 0; i < customers.length; i++) {
            tmp += customers[i];
            if (i > minutes - 1) {
                tmp -= customers[i - minutes];
            }
            max = Math.max(max, tmp);
        }
        return max + res;
    }
}
