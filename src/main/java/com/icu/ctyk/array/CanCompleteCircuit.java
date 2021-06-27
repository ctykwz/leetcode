package com.icu.ctyk.array;

/**
 * https://leetcode-cn.com/problems/gas-station/
 *
 * @author ctykwz on 2021-06-19 10:54
 */
public class CanCompleteCircuit {


    public int canCompleteCircuitV2(int[] gas, int[] cost) {
        int minGas = Integer.MAX_VALUE;
        int minIndex = 0;
        int gasValue = 0;
        for (int i = 0; i < gas.length; i++) {
            gasValue += gas[i] - cost[i];
            if (gasValue < minGas) {
                minGas = gasValue;
                minIndex = i;
            }
        }
        return gasValue != 0 ? -1 : (minIndex + 1) % gas.length;
    }


    public int canCompleteCircuit(int[] gas, int[] cost) {

        int size = gas.length;
        for (int start = 0; start < size; start++) {
            if (gas[start] < cost[start]) {
                continue;
            }
            int idx = (start + 1) % size;
            int gasValue = gas[start] - cost[start];
            // 从下个位置看下能不能走回来
            while (idx != start) {
                gasValue += gas[idx] - cost[idx];
                if (gasValue < 0) {
                    break;
                }
                idx = (idx + 1) % size;
            }
            if (idx == start) {
                return idx;
            }
        }
        return -1;
    }
}
