package com.icu.ctyk.other;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

/**
 * @author ctykwz on 2021-07-11 09:31
 */
public class TimeMap {

    private final Map<String, TreeMap<Integer, String>> container;

    /**
     * Initialize your data structure here.
     */
    public TimeMap() {
        this.container = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        container.computeIfAbsent(key, it -> new TreeMap<>()).put(timestamp, value);

    }

    public String get(String key, int timestamp) {
        if (!container.containsKey(key)) {
            return null;
        }
        return Optional.ofNullable(container.get(key).floorEntry(timestamp)).map(Map.Entry::getValue).orElse(null);
    }
}
