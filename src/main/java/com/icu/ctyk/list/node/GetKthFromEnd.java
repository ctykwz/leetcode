package com.icu.ctyk.list.node;

import java.util.Objects;

/**
 * @author ctykwz on 2021-06-04 18:18
 */
public class GetKthFromEnd {

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        while (k > 0) {
            fast = fast.next;
            k--;
        }
        while (Objects.nonNull(fast)) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
