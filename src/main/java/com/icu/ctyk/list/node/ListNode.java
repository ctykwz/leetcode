package com.icu.ctyk.list.node;

/**
 * @author ctykwz on 2021-06-02 17:49
 */
public class ListNode {

    public int val;

    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}