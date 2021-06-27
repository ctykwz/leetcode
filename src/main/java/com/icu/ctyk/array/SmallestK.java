package com.icu.ctyk.array;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author ctykwz on 2021-06-18 13:49
 */
public class SmallestK {

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(new SmallestK().smallestK(new int[]{1, 3, 5, 7, 2, 4, 6, 8}, 4))
        );
    }

    public int[] smallestK(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((left, right) -> right - left);
        for (int j : arr) {
            while (!queue.isEmpty() && queue.size() >= k && queue.peek() > j) {
                queue.poll();
            }
            queue.offer(j);
        }
        while (queue.size() > k) {
            queue.poll();
        }
        return queue.stream().mapToInt(it -> it).toArray();
    }
}
