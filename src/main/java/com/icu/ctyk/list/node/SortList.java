package com.icu.ctyk.list.node;

import java.util.List;
import java.util.Objects;

/**
 * @author ctykwz on 2021-06-10 14:39
 */
public class SortList {

    public static void main(String[] args) {
        ListNode node = new ListNode(4);
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(6);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(2);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode result = new SortList().sortList(node);
        System.out.println(result.toString());
    }


    public ListNode sortList(ListNode head) {
        if (Objects.isNull(head) || head.next == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            fast = Objects.isNull(fast.next) ? null : fast.next.next;
            slow = slow.next;
        }
        ListNode tail = slow;
        ListNode tmp = head;
        while (!Objects.equals(tmp.next, tail)) {
            tmp = tmp.next;
        }
        tmp.next = null;
        ListNode sortLeft = sortList(head);
        ListNode sortRight = sortList(tail);
        return subMerge(sortLeft, sortRight);
    }

    private ListNode subMerge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode tmp = dummy;
        while (Objects.nonNull(left) || Objects.nonNull(right)) {
            if (Objects.isNull(left) || Objects.nonNull(right) && left.val > right.val) {
                ListNode next = right.next;
                tmp.next = right;
                right = next;
                tmp = tmp.next;
            } else {
                ListNode next = left.next;
                tmp.next = left;
                left = next;
                tmp = tmp.next;
            }
        }
        return dummy.next;
    }
}
