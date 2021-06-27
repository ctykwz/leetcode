package com.icu.ctyk.num;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author ctykwz on 2021-06-25 14:57
 */
public class IntToRoman {

    public static void main(String[] args) {
        System.out.println(new IntToRoman().intToRoman(1994));
    }

    private static final LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

    static {
        map.put("M", 1000);
        map.put("CM", 900);
        map.put("D", 500);
        map.put("CD", 400);
        map.put("C", 100);
        map.put("XC", 90);
        map.put("L", 50);
        map.put("XL", 40);
        map.put("X", 10);
        map.put("IX", 9);
        map.put("V", 5);
        map.put("IV", 4);
        map.put("I", 1);
    }

    public String intToRoman(int num) {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            for (int i = 0; i < num / entry.getValue(); i++) {
                builder.append(entry.getKey());
            }
            num = num % entry.getValue();
        }
        return builder.toString();
    }
}
