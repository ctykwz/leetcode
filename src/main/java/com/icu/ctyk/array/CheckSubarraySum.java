package com.icu.ctyk.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ctykwz on 2021-06-02 16:20
 */
public class CheckSubarraySum {

    public static void main(String[] args) {
        System.out.println(new CheckSubarraySum().checkSubarraySumV2(new int[]{5, 0, 0, 0}, 3));
    }

    // (a+b)%k=((a%k)+b)%k=(a+(b%k))%k=((a%k)+(b%k))%k
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        Map<Integer, Integer> preIndexMap = new HashMap<>();
        preIndexMap.put(0, -1);
        int remainder = 0;
        for (int i = 0; i < nums.length; i++) {
            // (sum(i)%k + num[i]%k)%k 的结果与 (sum(i)+num(i))%k 相同，remainder = sum(i)%k
            remainder = (nums[i] + remainder) % k;
            if (preIndexMap.containsKey(remainder)) {
                if (i - preIndexMap.get(remainder) >= 2) {
                    return true;
                }
            } else {
                preIndexMap.put(remainder, i);
            }
        }
        return false;
    }

    // (a+b)%k=((a%k)+b)%k=(a+(b%k))%k=((a%k)+(b%k))%k
    public boolean checkSubarraySumV2(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        Map<Integer, Integer> preIndexMap = new HashMap<>();
        preIndexMap.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            // (sum(i)%k + num[i]%k)%k 的结果与 (sum(i)+num(i))%k 相同，remainder = sum(i)%k
            sum += nums[i];
            int remainder = (sum % k + k) % k;
            if (preIndexMap.containsKey(remainder)) {
                if (i - preIndexMap.getOrDefault(remainder, 0) > 1) {
                    return true;
                }
            } else {
                preIndexMap.put(remainder, i);
            }
        }
        return false;
    }
}
