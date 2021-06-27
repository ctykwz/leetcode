package com.icu.ctyk.list.node;

import java.util.Objects;
import java.util.Stack;
import java.util.concurrent.Semaphore;

/**
 * @author ctykwz on 2021-06-05 18:10
 */
public class CQueue {

    private Stack<Integer> input;
    private Stack<Integer> output;
    private int size = 0;

    public CQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }

    public void appendTail(int value) {
        input.push(value);
        size++;
    }

    public int deleteHead() {
        if (size == 0) {
            return -1;
        }
        if (!output.isEmpty()) {
            return output.pop();
        }
        while (Objects.nonNull(input.peek())) {
            output.push(input.pop());
        }
        return output.pop();
    }

}
