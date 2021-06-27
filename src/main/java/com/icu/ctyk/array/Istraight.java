package com.icu.ctyk.array;

import java.util.Objects;
import java.util.Random;

/**
 * @author ctykwz on 2021-06-03 11:10
 */
public class Istraight {

    public static void main(String[] args) {
        System.out.println(new Istraight().isStraight(new int[]{3, 0, 4, 5, 6}));
    }

    public boolean isStraight(int[] nums) {
        if (nums == null || nums.length < 5) {
            return false;
        }
        // 如果除了0没有重复值且max-min<5就是顺子
        sortArray(nums);
        int min = Integer.MAX_VALUE;
        int max = nums[nums.length - 1];
        for (int i = 0; i < nums.length - 1; i++) {
            if (Objects.equals(nums[i], 0)) {
                continue;
            }
            if (nums[i] == nums[i + 1]) {
                return false;
            }
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        return max - min < 5;
    }


    public void sortArray(int[] input) {
        if (input == null) {
            return;
        }
        partitionSort(input, 0, input.length - 1);
    }

    private void partitionSort(int[] input, int left, int right) {
        if (left >= right) {
            return;
        }
        int pos = randomPos(input, left, right);
        partitionSort(input, left, pos);
        partitionSort(input, pos + 1, right);
    }

    private int randomPos(int[] input, int left, int right) {
        int randomValue = new Random().nextInt(right - left + 1) + left;
        swap(input, randomValue, right);
        int pos = 0;
        for (int i = left; i < right; i++) {
            if (input[i] < input[right]) {
                swap(input, pos++, i);
            }
        }
        swap(input, pos, right);
        return pos;
    }


    private void swap(int[] input, int left, int right) {
        int tmp = input[left];
        input[left] = input[right];
        input[right] = tmp;
    }

}
