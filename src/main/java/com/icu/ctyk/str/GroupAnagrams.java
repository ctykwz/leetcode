package com.icu.ctyk.str;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ctykwz on 2021-06-24 16:31
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hashContainer = new HashMap<>();
        for (String str : strs) {
            int[] counter = new int[26];
            char[] chars = str.toCharArray();
            for (char aChar : chars) {
                ++counter[aChar - 'a'];
            }
            StringBuilder builder = new StringBuilder();
            for (int i : counter) {
                builder.append('a' + i).append(i);
            }
            String val = builder.toString();
            hashContainer.computeIfAbsent(val, it -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(hashContainer.values());
    }
}
