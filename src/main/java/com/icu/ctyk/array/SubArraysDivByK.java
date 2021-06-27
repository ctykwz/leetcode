package com.icu.ctyk.array;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/subarray-sums-divisible-by-k/
 *
 * @author ctykwz on 2021-06-02 20:46
 */
public class SubArraysDivByK {

    public static void main(String[] args) {
        System.out.println(new SubArraysDivByK().subarraysDivByK(new int[]{-1, 2, 9}, 2));
    }

    // (a+b)%k=((a%k)+b)%k=(a+(b%k))%k=((a%k)+(b%k))%k
    public int subarraysDivByK(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> preMap = new HashMap<>();
        preMap.put(0, 1);
        int sum = 0;
        int cnt = 0;
        for (int num : nums) {
            // (sum(i)%k + num[i]%k)%k 的结果与 (sum(i)+num(i))%k 相同，remainder = sum(i)%k
            sum += num;
            int reminder = (sum % k + k) % k;
            cnt += preMap.getOrDefault(reminder, 0);
            preMap.put(reminder, preMap.getOrDefault(reminder, 0) + 1);
        }
        return cnt;
    }
}
