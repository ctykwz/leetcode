package com.icu.ctyk.array;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 *
 * @author ctykwz on 2021-06-19 11:28
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        int buy = -prices[0];
        int sell = 0;
        int lock = 0;
        for (int price : prices) {
            buy = Math.max(buy, lock - price);
            lock = sell;
            sell = Math.max(sell, buy + price);
        }
        return sell;
    }
}
