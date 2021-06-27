package com.icu.ctyk.str;

import java.util.Stack;

/**
 * @author ctykwz on 2021-06-10 22:28
 */
public class RemoveDuplicateLetters {

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicateLetters().removeDuplicateLetters("bdcabc"));
    }

    public String removeDuplicateLetters(String s) {
        int[] occur = new int[26];
        for (char c : s.toCharArray()) {
            occur[c - 'a']++;
        }
        Stack<Character> stack = new Stack<>();
        boolean[] visited = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = c - 'a';
            if (!visited[index]) {
                // 存在多个未使用字符，且当前栈底元素比当前的字符大，则丢弃 栈里只维护一个期望字符 如果锁字典序不存在一个重复字符
                // 因为前置已经被设置为已经访问  所以这里不会再出栈
                while (!stack.isEmpty() && stack.peek() > c && occur[c - 'a'] > 0 && occur[stack.peek() - 'a'] > 0) {
                    visited[stack.peek() - 'a'] = false;
                    stack.pop();
                }
                stack.push(c);
                visited[index] = true;
            }
            occur[index]--;
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }
        return builder.reverse().toString();
    }
}
