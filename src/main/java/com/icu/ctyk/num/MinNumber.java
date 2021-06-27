package com.icu.ctyk.num;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author ctykwz on 2021-06-21 22:28
 */
public class MinNumber {

    public static void main(String[] args) {
        System.out.println(new MinNumber().minNumber(new int[]{3, 30, 34, 5, 9}));
    }

    // 字典序
    public String minNumber(int[] nums) {
        return Arrays.stream(nums).mapToObj(String::valueOf)
                .sorted((left, right) -> (left + right).compareTo(right + left))
                .collect(Collectors.joining(""));
    }
}
