package com.icu.ctyk.node.base;

/**
 * @author ctykwz on 2021-06-20 15:24
 */
public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}