package com.icu.ctyk.str;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.ToIntFunction;

/**
 * @author xiyun on 2021-07-03 11:08
 */
public class FrequencySort {

    public static void main(String[] args) {
        System.out.println(new FrequencySort().frequencySort("tree"));
    }

    public String frequencySort(String s) {
        Map<Character, Integer> frequency = new HashMap<>();
        for (char token : s.toCharArray()) {
            frequency.put(token, frequency.getOrDefault(token, 0) + 1);
        }
        StringBuilder builder = new StringBuilder();
        frequency.entrySet().stream()
                .sorted(Comparator.comparingInt((ToIntFunction<Map.Entry<Character, Integer>>) Map.Entry::getValue).reversed())
                .forEach(it -> {
                    for (int i = 0; i < it.getValue(); i++) {
                        builder.append(it.getKey());
                    }
                });
        return builder.toString();
    }
}
