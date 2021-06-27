package com.icu.ctyk.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author ctykwz on 2021-06-26 20:57
 */
public class EraseOverlapIntervals {

    public static void main(String[] args) {
        System.out.println(
                new EraseOverlapIntervals().eraseOverlapIntervals(
                        new int[][]{
                                new int[]{1, 2},
                                new int[]{2, 3},
                                new int[]{3, 4},
                                new int[]{1, 3}
                        }
                )
        );
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <= 1) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(it -> it[1]));
        int right = intervals[0][1];
        int validCnt = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= right) {
                validCnt += 1;
                right = intervals[i][1];
            }
        }
        return intervals.length - validCnt;
    }
}
