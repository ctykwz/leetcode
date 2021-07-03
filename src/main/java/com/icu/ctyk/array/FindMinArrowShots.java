package com.icu.ctyk.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author ctykwz on 2021-07-03 21:16
 */
public class FindMinArrowShots {

    public static void main(String[] args) {
        System.out.println(
                new FindMinArrowShots().findMinArrowShots(
                        new int[][]{
                                new int[]{10, 16},
                                new int[]{2, 8},
                                new int[]{1, 6},
                                new int[]{7, 12}
                        })
        );
    }

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(it -> it[0]));
        int res = 1;
        int[] left = points[0];
        // 找重复区间
        for (int i = 1; i <= points.length; i++) {
            if (points[i][0] < left[1]) {
                left = points[i][1] < left[1] ? points[i] : left;
            } else {
                left = points[i];
                res += 1;
            }
        }
        return res;
    }
}
