package com.icu.ctyk.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ctykwz on 2021-06-03 09:40
 */
public class FindMaxLength {

    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // value-index
        Map<Integer, Integer> preMap = new HashMap<>();
        preMap.put(0, -1);
        int maxLength = 0;
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                counter--;
            } else {
                counter++;
            }
            if (preMap.containsKey(counter)) {
                maxLength = Math.max(i - preMap.get(counter), maxLength);
            } else {
                preMap.put(counter, i);
            }
        }
        return maxLength;
    }
}
