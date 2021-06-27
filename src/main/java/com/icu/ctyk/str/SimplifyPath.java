package com.icu.ctyk.str;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

/**
 * https://leetcode-cn.com/problems/simplify-path/
 *
 * @author ctykwz on 2021-06-20 09:19
 */
public class SimplifyPath {

    public static void main(String[] args) {
        System.out.println(new SimplifyPath().simplifyPath("/../"));
    }

    public String simplifyPath(String path) {
        Deque<String> queue = new LinkedList<>();
        for (String str : path.split("/")) {
            if (Objects.equals(str, "..")) {
                if (!queue.isEmpty()){
                    queue.pop();
                }
            } else if (!Objects.equals(str, ".") && !Objects.equals(str, "")) {
                queue.push(str);
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!queue.isEmpty()) {
            builder.append("/").append(queue.pollLast());
        }
        return builder.length() == 0 ? "/" : builder.toString();
    }
}
