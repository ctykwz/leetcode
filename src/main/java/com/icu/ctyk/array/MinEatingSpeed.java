package com.icu.ctyk.array;

/**
 * https://leetcode-cn.com/problems/koko-eating-bananas/
 *
 * @author ctykwz on 2021-06-28 12:14
 */
public class MinEatingSpeed {

    public int minEatingSpeed(int[] piles, int h) {
        int right = 0;
        // 一次性只能吃最多一堆
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        int left = 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int eatHour = 0;
            for (int pile : piles) {
                // 因为要向上取整 所以 pile/mid ---> (pile+mid-1)/mid
                eatHour += (pile + mid - 1) / mid;
            }
            if (eatHour > h) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
