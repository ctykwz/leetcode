package com.icu.ctyk.cache;

import com.icu.ctyk.list.node.ListNode;
import com.icu.ctyk.list.node.RemoveNthFromEnd;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author ctykwz on 2021-06-04 16:59
 */
public class LRUCache {

    public static void main(String[] args) {
        LRUCache result = new LRUCache(2);
        result.get(2);
        result.put(2, 6);
        result.get(1);
        result.put(1, 5);
        result.put(1, 2);
        result.get(1);
        result.get(2);
        System.out.println(result);
    }

    private final LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;

    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        int value = cache.get(key);
        cache.remove(key);
        cache.put(key, value);
        return value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.remove(key);
        } else if (cache.size() >= capacity) {
            Integer old = cache.entrySet().iterator().next().getKey();
            cache.remove(old);
        }
        cache.put(key, value);
    }
}
