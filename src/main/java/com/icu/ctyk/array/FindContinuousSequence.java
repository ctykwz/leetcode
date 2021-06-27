package com.icu.ctyk.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ctykwz on 2021-06-06 11:50
 */
public class FindContinuousSequence {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new FindContinuousSequence().findContinuousSequenceV2(9)));
    }

    public int[][] findContinuousSequenceV2(int target) {
        int sum = 0;
        int left = 1;
        int right = 1;
        List<int[]> result = new ArrayList<>();
        while (right < target && left < target) {
            if (sum > target) {
                sum -= left;
                left++;
            } else if (sum == target) {
                int[] cur = new int[right - left];
                for (int i = left; i < right; i++) {
                    cur[i - left] = i;
                }
                result.add(cur);
                sum -= left;
                left++;
            } else {
                sum += right;
                right++;
            }
        }
        return result.toArray(new int[][]{});
    }

    public int[][] findContinuousSequence(int target) {
        List<int[]> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        find(result, cur, target, 1, 0, 2);
        return result.toArray(new int[][]{});
    }

    private void find(List<int[]> result, List<Integer> cur, int target, int left, int curValue, int size) {
        if (curValue == target && cur.size() >= size) {
            result.add(cur.stream().mapToInt(i -> i).toArray());
            return;
        }
        if (curValue > target) {
            return;
        }
        for (int i = left; i < target; i++) {
            if (cur.size() == 0 || cur.get(cur.size() - 1) == i - 1) {
                cur.add(i);
                find(result, cur, target, i + 1, curValue + i, size);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
