package com.icu.ctyk.array;

import com.icu.ctyk.list.node.ListNode;

/**
 * @author ctykwz on 2021-06-10 16:33
 */
public class AddTwoNumbersV2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tmp = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int val = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            tmp.next = new ListNode(val % 10);
            carry = val / 10;
            tmp = tmp.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (carry > 0) {
            tmp.next = new ListNode(carry);
        }
        return dummy.next;
    }
}
