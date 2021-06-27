package com.icu.ctyk.num;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ctykwz on 2021-06-26 13:27
 */
public class LastRemaining {

    public static void main(String[] args) {
        System.out.println(new LastRemaining().lastRemaining(5, 3));
    }

    public int lastRemaining(int n, int m) {
        List<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tmp.add(i);
        }
        int idx = 0;
        while (tmp.size() != 1) {
            idx = (idx + m - 1) % tmp.size();
            tmp.remove(idx);
        }
        return tmp.get(0);
    }
}
