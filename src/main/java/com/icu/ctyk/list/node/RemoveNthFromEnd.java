package com.icu.ctyk.list.node;

import java.util.List;
import java.util.Objects;

/**
 * @author ctykwz on 2021-06-02 17:49
 */
public class RemoveNthFromEnd {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode result = new RemoveNthFromEnd().removeNthFromEnd(node4, 1);
        System.out.println(result.toString());
    }

    //使用一趟扫描实现
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (Objects.isNull(head)) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode left = dummy;
        ListNode right = dummy.next;
        while (n > 0) {
            right = right.next;
            n--;
        }
        while (true) {
            if (Objects.isNull(right) && Objects.nonNull(left)) {
                left.next = left.next.next;
                break;
            }
            left = left.next;
            right = right.next;
        }
        return dummy.next;
    }
}
