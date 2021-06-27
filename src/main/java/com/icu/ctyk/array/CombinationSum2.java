package com.icu.ctyk.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ctykwz on 2021-06-05 17:27
 */
public class CombinationSum2 {

    // 跟v1的不同在于这里重复数据只能用一次
    public static void main(String[] args) {
        System.out.println(new CombinationSum2().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> cur = new ArrayList<>();
        generate(candidates, result, cur, target, 0);
        return result;
    }

    private void generate(int[] candidates, List<List<Integer>> result, List<Integer> cur, int less, int index) {
        if (less == 0) {
            result.add(new ArrayList<>(cur));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (less < candidates[i]) {
                continue;
            }
            cur.add(candidates[i]);
            // 因为是可以重复使用
            generate(candidates, result, cur, less - candidates[i], i + 1);
            cur.remove(cur.size() - 1);
            while (i < candidates.length - 1 && candidates[i] == candidates[i + 1]) {
                i++;
            }
        }
    }
}
