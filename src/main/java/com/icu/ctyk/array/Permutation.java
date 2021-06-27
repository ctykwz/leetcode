package com.icu.ctyk.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ctykwz on 2021-06-04 17:50
 */
public class Permutation {


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Permutation().permutation("abcc")));
    }


    public String[] permutation(String s) {
        List<String> result = new ArrayList<>();
        generate(s.toCharArray(), 0, result);
        return result.toArray(new String[0]);
    }

    private void generate(char[] chars, int startIndex, List<String> result) {
        if (startIndex == chars.length - 1) {
            result.add(new String(chars));
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int i = startIndex; i < chars.length; i++) {
            if (set.contains(chars[i])) {
                continue;
            }
            set.add(chars[i]);
            swap(chars, startIndex, i);
            generate(chars, startIndex + 1, result);
            swap(chars, startIndex, i);
        }
    }

    private void swap(char[] chars, int left, int right) {
        if (left == right) {
            return;
        }
        char tmp = chars[left];
        chars[left] = chars[right];
        chars[right] = tmp;
    }
}
