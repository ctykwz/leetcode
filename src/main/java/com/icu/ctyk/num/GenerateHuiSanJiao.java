package com.icu.ctyk.num;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ctykwz on 2021-06-20 17:40
 */
public class GenerateHuiSanJiao {

    public static void main(String[] args) {
        System.out.println(new GenerateHuiSanJiao().generate(5));
    }

    public List<List<Integer>> generate(int numRows) {
        if (numRows <= 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> layer = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (i == 0 || j == 0 || j == i) {
                    layer.add(1);
                } else {
                    layer.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(layer);
        }
        return res;
    }
}
