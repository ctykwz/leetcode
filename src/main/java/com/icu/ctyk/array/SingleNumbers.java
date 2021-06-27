package com.icu.ctyk.array;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
 *
 * @author ctykwz on 2021-06-21 09:30
 */
public class SingleNumbers {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SingleNumbers().singleNumbers(new int[]{4, 1, 4, 6})));
    }

    // 不会
    public int[] singleNumbers(int[] nums) {
        int sum = 0;
        // 0^x==x  所以只会剩下  z = x ^ y
        for (int num : nums) {
            sum ^= num;
        }
        // 取最低位的1 也可以写成 x^(x&(x-1))，x&(x-1)消去最低位1，再^x，结果只保留最低位1
        int low = -sum & sum;
        int[] res = new int[2];
        // 相同为0  不同为1
        for (int num : nums) {
            if ((num & low) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }
}
