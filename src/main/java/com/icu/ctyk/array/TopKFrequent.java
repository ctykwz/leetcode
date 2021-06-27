package com.icu.ctyk.array;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author ctykwz on 2021-06-18 14:52
 */
public class TopKFrequent {

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(new TopKFrequent().topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2))
        );
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> occur = new HashMap<>();
        for (int num : nums) {
            occur.put(num, occur.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> queue =
                new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> num : occur.entrySet()) {
            while (!queue.isEmpty() && queue.size() >= k && queue.peek().getValue() < num.getValue()) {
                queue.poll();
            }
            queue.offer(num);
        }
        while (queue.size() > k) {
            queue.poll();
        }
        return queue.stream().mapToInt(Map.Entry::getKey).toArray();
    }
}
