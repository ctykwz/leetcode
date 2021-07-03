package com.icu.ctyk.list.node;

/**
 * @author ctykwz on 2021-07-03 22:12
 */
public class MiddleNode {

    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
