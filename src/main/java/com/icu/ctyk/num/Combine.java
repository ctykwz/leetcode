package com.icu.ctyk.num;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ctykwz on 2021-06-20 10:53
 */
public class Combine {

    public static void main(String[] args) {
        System.out.println(new Combine().combine(4, 2));
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), 1, n, k);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> container, int start, int n, int k) {
        if (container.size() == k) {
            res.add(new ArrayList<>(container));
        }
        if (container.size() > k) {
            return;
        }

        int range = n - (k - container.size()) + 1;
        for (int i = start; i <= range; i++) {
            container.add(i);
            dfs(res, container, i + 1, n, k);
            container.remove(container.size() - 1);
        }
    }
}
