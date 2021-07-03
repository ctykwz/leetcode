package com.icu.ctyk.list.node;

/**
 * @author ctykwz on 2021-06-18 21:24
 */
public class DeleteNode {

    public void deleteNode(ListNode node) {
        if (node == null || node.next == null) {
            return;
        }
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
