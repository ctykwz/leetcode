package com.icu.ctyk.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.ToIntFunction;

/**
 * @author ctykwz on 2021-06-20 15:44
 */
public class ReconstructQueue406 {

    public static void main(String[] args) {
        System.out.println(
                Arrays.deepToString(new ReconstructQueue406().reconstructQueue(
                        new int[][]{
                                new int[]{7, 0},
                                new int[]{4, 4},
                                new int[]{7, 1},
                                new int[]{5, 0},
                                new int[]{6, 1},
                                new int[]{5, 2}
                        }
                ))
        );
    }

    // 暂时不是很懂  晚上再看
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (left, right) -> left[0] != right[0] ? right[0] - left[0] : left[1] - right[1]);
        ArrayList<int[]> res = new ArrayList<>();
        for (int[] person : people) {
            res.add(person[1], person);
        }
        return res.toArray(new int[][]{});
    }

}
