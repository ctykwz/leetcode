package com.icu.ctyk.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ctykwz on 2021-06-05 16:29
 */
public class CombinationSum {

    public static void main(String[] args) {
        System.out.println(new CombinationSum().combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
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
            generate(candidates, result, cur, less - candidates[i], i);
            cur.remove(cur.size() - 1);
        }
    }
}
