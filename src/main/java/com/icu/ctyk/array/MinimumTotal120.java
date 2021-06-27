package com.icu.ctyk.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ctykwz on 2021-06-20 16:24
 */
public class MinimumTotal120 {

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        item.add(2);
        List<Integer> item1 = new ArrayList<>();
        item1.add(3);
        item1.add(4);
        List<Integer> item2 = new ArrayList<>();
        item2.add(6);
        item2.add(5);
        item2.add(7);
        List<Integer> item3 = new ArrayList<>();
        item3.add(4);
        item3.add(1);
        item3.add(8);
        item3.add(3);
        triangle.add(item);
        triangle.add(item1);
        triangle.add(item2);
        triangle.add(item3);
        System.out.println(new MinimumTotal120().minimumTotal(triangle));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[][] dp = new int[size + 1][size + 1];
        for (int i = size - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[i][j] = Math.min(dp[i + 1][j + 1], dp[i + 1][j]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }

    public int minimumTotalV2(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[] dp = new int[size + 1];
        for (int i = size - 1; i >= 0; i--) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j < row.size(); j++) {
                dp[j] = Math.min(dp[j + 1], dp[j]) + row.get(j);
            }
        }
        return dp[0];
    }
}
