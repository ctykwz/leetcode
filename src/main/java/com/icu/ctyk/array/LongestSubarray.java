package com.icu.ctyk.array;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @author ctykwz on 2021-06-29 13:59
 */
public class LongestSubarray {

    public int longestSubarray(int[] nums, int limit) {
        int len = nums.length;
        int right = 0;
        int left = 0;
        // value - len
        int res = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        while (right < len) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            // 需要满足最大值跟最小值差不超过limit
            while (map.lastKey() - map.firstKey() > limit) {
                map.put(nums[left], map.getOrDefault(nums[left], 0) - 1);
                if (map.get(nums[left]) <= 0) {
                    map.remove(nums[left]);
                }
                left += 1;
            }
            res = Math.max(res, right - left + 1);
            right += 1;
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(
                new LongestSubarray().longestSubarrayV3(
                        new int[]{10, 1, 2, 4, 7, 2},
                        5
                )
        );
    }

    public int longestSubarrayV3(int[] nums, int limit) {
        Deque<Integer> max = new LinkedList<>();
        Deque<Integer> min = new LinkedList<>();
        int len = nums.length;
        int right = 0;
        int left = 0;
        int res = 0;
        while (right < len) {
            //最大堆
            while (!max.isEmpty() && max.peekLast() < nums[right]) {
                max.pollLast();
            }
            //最小堆
            while (!min.isEmpty() && min.peekLast() > nums[right]) {
                min.pollLast();
            }
            max.offerLast(nums[right]);
            min.offerLast(nums[right]);
            while (!max.isEmpty() && !min.isEmpty() && max.peekFirst() - min.peekFirst() > limit) {
                if (max.peekFirst() == nums[left]) {
                    max.pollFirst();
                }
                if (min.peekFirst() == nums[left]) {
                    min.pollFirst();
                }
                left += 1;
            }
            res = Math.max(res, right - left + 1);
            right += 1;
        }
        return res;
    }


    // 优先队列
    public int longestSubarrayV2(int[] nums, int limit) {
        PriorityQueue<Integer> max = new PriorityQueue<>((left, right) -> right - left);
        PriorityQueue<Integer> min = new PriorityQueue<>();
        int len = nums.length;
        int right = 0;
        int left = 0;
        int res = 0;
        while (right < len) {
            max.offer(nums[right]);
            min.offer(nums[right]);
            while (!max.isEmpty() && !min.isEmpty() && max.peek() - min.peek() > limit) {
                max.remove(nums[left]);
                min.remove(nums[left]);
                left += 1;
            }
            res = Math.max(res, right - left + 1);
            right += 1;
        }
        return res;
    }

}
