package com.icu.ctyk.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author ctykwz on 2021-06-07 21:06
 */
public class CanAttendMeetings {

    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(it -> it[0]));
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][0] == intervals[i + 1][0] || intervals[i + 1][0] <= intervals[i][1]) {
                return false;
            }
        }
        return true;
    }
}
