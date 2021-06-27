package com.icu.ctyk.array;

import java.util.Arrays;

/**
 * @author ctykwz on 2021-06-27 09:57
 */
public class MinDifference {

    public static void main(String[] args) {
        int[] cnt = new MinDifference().minDifference(new int[]{4, 5, 2, 2, 7, 10},
                new int[][]{
                        new int[]{0, 1},
                        new int[]{1, 2},
                        new int[]{2, 3},
                        new int[]{3, 5}
                });
        System.out.println(Arrays.toString(cnt));
    }

    public int[] minDifference(int[] nums, int[][] queries) {
        // 统计当前index中已经出现的数字个数
        int[][] indexOccur = new int[nums.length][101];
        int[] occur = new int[101];
        for (int i = 0; i < nums.length; i++) {
            occur[nums[i]]++;
            indexOccur[i] = occur.clone();
        }
        int len = queries.length;
        int[] res = new int[len];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            int ans = Integer.MAX_VALUE;
            int pre = 0;

            for (int j = 0; j <= 100; j++) {
                // left 的前缀中数字出现的次数一定是小于等于right的 left - 1是因为需要包含左区间
                int diff = left == 0 ? indexOccur[right][j] : indexOccur[right][j] - indexOccur[left - 1][j];
                if (diff > 0) {
                    if (pre > 0) {
                        ans = Math.min(ans, j - pre);
                    }
                    pre = j;
                }
            }
            res[i] = ans == Integer.MAX_VALUE ? -1 : ans;
        }
        return res;
    }

}
