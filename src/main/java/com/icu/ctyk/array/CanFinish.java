package com.icu.ctyk.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/course-schedule/
 *
 * @author ctykwz on 2021-06-19 12:07
 */
public class CanFinish {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> course = new HashMap<>();
        int[] inDegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            course.computeIfAbsent(prerequisite[1], it -> new HashSet<>())
                    .add(prerequisite[0]);
            inDegree[prerequisite[0]]++;
        }
        // 看下哪些课没有被依赖
        Queue<Integer> degree = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                degree.offer(i);
            }
        }
        while (!degree.isEmpty()) {
            int root = degree.poll();
            inDegree[root]--;
            numCourses--;
            Set<Integer> relations = course.getOrDefault(root, new HashSet<>());
            for (Integer relation : relations) {
                if (--inDegree[relation] == 0) {
                    degree.offer(relation);
                }
            }
        }
        return numCourses == 0;
    }

}
