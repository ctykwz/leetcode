package com.icu.ctyk.str;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ctykwz on 2021-06-06 15:22
 */
public class LengthOfLongestSubstring {


    public static void main(String[] args) {
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring(" "));
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charStart = new HashMap<>();
        int start = 0;
        int max = 0;
        for (int index = 0; index < s.length(); index++) {
            start = Math.max(start, charStart.getOrDefault(s.charAt(index), -1) + 1);
            max = Math.max(max, index - start + 1);
            charStart.put(s.charAt(index), index);
        }
        return max;
    }
}
