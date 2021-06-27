package com.icu.ctyk.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author ctykwz on 2021-06-26 12:37
 */
public class TopKFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {

        return Arrays.stream(words).collect(
                Collectors.groupingBy(it -> it, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Comparator.comparing((Function<Map.Entry<String, Long>, Long>) Map.Entry::getValue).reversed()
                        .thenComparing(Map.Entry::getKey))
                .limit(k)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());


    }
}
