package com.icu.ctyk.array;

/**
 * @author ctykwz on 2021-06-25 14:39
 */
public class CorpFlightBookings {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] counter = new int[n];
        for (int[] booking : bookings) {
            int from = booking[0];
            int to = booking[1];
            counter[from - 1] += booking[2];
            if (to < n) {
                //n个航班
                counter[to - 1] -= booking[2];
            }
        }
        for (int i = 1; i < counter.length; i++) {
            counter[i] += counter[i - 1];
        }
        return counter;
    }
}
