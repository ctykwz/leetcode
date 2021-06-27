package com.icu.ctyk.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ctykwz on 2021-06-16 11:41
 */
public class IsIsomorphic {

    /**
     * 每个出现的字符都应当映射到另一个字符 且 source 与 dest不一样
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> s2t = new HashMap<>();
        Map<Character, Character> t2s = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character sChart = s.charAt(i);
            Character tChart = t.charAt(i);
            if (s2t.containsKey(sChart) && s2t.get(sChart) != tChart || t2s.containsKey(tChart) && t2s.get(tChart) != sChart) {
                return false;
            }
            s2t.put(sChart, tChart);
            t2s.put(tChart, sChart);
        }
        return true;
    }
}
