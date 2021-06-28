package com.icu.ctyk.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/bus-routes/
 *
 * @author ctykwz on 2021-06-28 21:01
 */
public class NumBusesToDestination {

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        //服务站可以到达的线路
        Map<Integer, Set<Integer>> station2LineMap = new HashMap<>();
        // 入度为0的线路及对应的点
        Map<Integer, Integer> lineDistance = new HashMap<>();
        // 入度为0的点（source）
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < routes.length; i++) {
            for (int station : routes[i]) {
                if (station == source) {
                    queue.offer(i);
                    lineDistance.put(i, 1);
                }
                station2LineMap.computeIfAbsent(station, it -> new HashSet<>()).add(i);
            }
        }

        while (!queue.isEmpty()) {
            int line = queue.poll();
            int distance = lineDistance.get(line);

            for (int station : routes[line]) {
                if (station == target) {
                    return distance;
                }
                Set<Integer> lines = station2LineMap.get(station);
                if (lines == null || lines.size() == 0) {
                    continue;
                }
                for (Integer item : lines) {
                    if (!lineDistance.containsKey(item)) {
                        // 换线
                        lineDistance.put(item, distance + 1);
                        queue.offer(item);
                    }
                }
            }
        }
        return -1;
    }
}
