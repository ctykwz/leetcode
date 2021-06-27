package com.icu.ctyk.array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.ToIntFunction;

/**
 * @author ctykwz on 2021-06-07 20:46
 */
public class MinMeetingRooms {

    public int minMeetingRooms(int[][] intervals) {
        List<int[]> tmp = new ArrayList<>();
        for (int[] interval : intervals) {
            tmp.add(new int[]{interval[0], 1});
            tmp.add(new int[]{interval[1], -1});
        }
        tmp.sort(Comparator.comparingInt((ToIntFunction<int[]>) value -> value[0]).thenComparing(it -> it[1]));
        int max = 0;
        int cur = 0;
        for (int[] it : tmp) {
            cur += it[1];
            max = Math.max(cur, max);
        }
        return max;
    }
}
