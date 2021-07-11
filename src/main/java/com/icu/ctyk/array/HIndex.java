package com.icu.ctyk.array;

import java.util.Arrays;

/**
 * @author ctykwz on 2021-07-11 09:23
 */
public class HIndex {

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            int citation = citations[i];
            int h = citations.length - i;
            if (citation >= h) {
                return citation;
            }
        }
        return 0;
    }
}
