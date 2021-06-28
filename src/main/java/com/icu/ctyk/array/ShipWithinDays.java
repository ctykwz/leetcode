package com.icu.ctyk.array;

/**
 * @author ctykwz on 2021-06-28 11:55
 */
public class ShipWithinDays {

    public static void main(String[] args) {
        System.out.println(
                new ShipWithinDays().shipWithinDays(new int[]{1, 2, 3, 1, 1}, 4)
        );
    }

    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;
        for (int weight : weights) {
            right += weight;
            left = Math.max(left, weight);
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            int curWeight = 0;
            int needDay = 1;
            for (int weight : weights) {
                if (curWeight + weight > mid) {
                    needDay += 1;
                    curWeight = 0;
                }
                curWeight += weight;
            }
            if (needDay > days) {
                //运力不足
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
