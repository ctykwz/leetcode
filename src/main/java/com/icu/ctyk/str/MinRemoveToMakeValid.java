package com.icu.ctyk.str;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * @author ctykwz on 2021-06-24 17:48
 */
public class MinRemoveToMakeValid {

    public static void main(String[] args) {
        System.out.println(new MinRemoveToMakeValid().minRemoveToMakeValid("())()((("));
    }

    public String minRemoveToMakeValid(String s) {
        Stack<Integer> index = new Stack<>();
        Set<Integer> indexToRemove = new HashSet<>();
        for (int i = 0; i < s.toCharArray().length; i++) {
            if (s.charAt(i) == '(') {
                index.push(i);
            } else if (s.charAt(i) == ')') {
                if (index.isEmpty()) {
                    indexToRemove.add(i);
                } else {
                    index.pop();
                }
            }
        }
        indexToRemove.addAll(index);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.toCharArray().length; i++) {
            if (indexToRemove.contains(i)) {
                continue;
            }
            builder.append(s.charAt(i));
        }
        return builder.toString();
    }
}
