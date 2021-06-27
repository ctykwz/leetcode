package com.icu.ctyk.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ctykwz on 2021-06-05 17:39
 */
public class CombinationSum3 {

    // https://leetcode-cn.com/problems/combination-sum-iii/
    public static void main(String[] args) {
        System.out.println(new CombinationSum3().combinationSum3(2, 18));
    }

    public List<List<Integer>> combinationSum3(int size, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        generate(size, result, cur, 1, target);
        return result;
    }

    private void generate(int size, List<List<Integer>> result, List<Integer> cur, int left, int less) {
        if (less == 0 && cur.size() == size) {
            result.add(new ArrayList<>(cur));
            return;
        }
        if (cur.size() > size) {
            return;
        }
        int edge = Math.min(less, 9);
        for (int i = left; i <= edge; i++) {
            cur.add(i);
            generate(size, result, cur, i + 1, less - i);
            cur.remove(cur.size() - 1);
        }
    }
}
