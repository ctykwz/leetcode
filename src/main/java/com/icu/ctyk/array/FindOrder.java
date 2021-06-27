package com.icu.ctyk.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author ctykwz on 2021-06-17 16:39
 */
public class FindOrder {

    /**
     * 课程信息
     *
     * @param numCourses    课程数
     * @param prerequisites 依赖
     * @return 课表
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0 || prerequisites == null || prerequisites.length == 0) {
            return new int[0];
        }
        // 课程：依赖
        Map<Integer, HashSet<Integer>> courseRelations = new HashMap<>();
        int[] degree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            courseRelations.computeIfAbsent(prerequisite[1], it -> new HashSet<>()).add(prerequisite[0]);
            degree[prerequisite[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            // 入度为0，不依赖任何课程
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }
        int[] result = new int[numCourses];
        int cnt = 0;
        while (!queue.isEmpty()) {
            Integer head = queue.poll();
            result[cnt] = head;
            cnt++;
            // 看下有谁依赖了入读为0的课程
            HashSet<Integer> relations = courseRelations.getOrDefault(head, new HashSet<>());
            for (Integer relation : relations) {
                degree[relation]--;
                if (degree[relation] == 0) {
                    queue.offer(relation);
                }
            }
        }
        return cnt == numCourses ? result : new int[]{};
    }
}
