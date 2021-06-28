package com.icu.ctyk.str;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ctykwz on 2021-06-28 11:38
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicates().removeDuplicates(
                "abbaca"
        ));
    }

    public String removeDuplicates(String s) {
        Deque<Character> characters = new LinkedList<>();
        for (char token : s.toCharArray()) {
            if (!characters.isEmpty() && characters.peekLast() == token) {
                while (!characters.isEmpty() && characters.peekLast() == token) {
                    characters.pollLast();
                }
            } else {
                characters.offerLast(token);
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!characters.isEmpty()) {
            builder.append(characters.pollFirst());
        }
        return builder.toString();
    }
}
