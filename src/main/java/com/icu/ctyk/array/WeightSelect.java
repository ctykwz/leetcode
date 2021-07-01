package com.icu.ctyk.array;

import java.util.Random;

/**
 * https://leetcode-cn.com/problems/random-pick-with-weight/
 *
 * @author ctykwz on 2021-07-01 10:27
 */
public class WeightSelect {

    private static final Random random = new Random();
    private static int[] prefix;

    // 值越小 概率越小，数字即权重
    public WeightSelect(int[] w) {
        prefix = new int[w.length];
        prefix[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            prefix[i] = prefix[i - 1] + w[i];
        }
    }

    public int pickIndex() {
        int target = random.nextInt(prefix[prefix.length - 1]);
        int right = prefix.length - 1;
        int left = 0;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (prefix[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
