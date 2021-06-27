package com.icu.ctyk.list.node;

import java.util.Objects;

/**
 * @author ctykwz on 2021-06-10 17:40
 */
public class DetectCycle {

    public static void main(String[] args) {
        ListNode node = new ListNode(-21);
        ListNode node1 = new ListNode(10);
        node.next = node1;
        ListNode node2 = new ListNode(17);
        node1.next = node2;
        ListNode node3 = new ListNode(8);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        ListNode node5 = new ListNode(26);
        node4.next = node5;
        ListNode node6 = new ListNode(5);
        node5.next = node6;
        ListNode node7 = new ListNode(35);
        node6.next = node7;
        ListNode node8 = new ListNode(33);
        node7.next = node8;
        ListNode node9 = new ListNode(-7);
        node8.next = node9;
        ListNode node10 = new ListNode(-16);
        node9.next = node10;
        ListNode node11 = new ListNode(27);
        node10.next = node11;
        ListNode node12 = new ListNode(-12);
        node11.next = node12;
        ListNode node13 = new ListNode(6);
        node12.next = node13;
        ListNode node14 = new ListNode(29);
        node13.next = node14;
        ListNode node15 = new ListNode(-12);
        node14.next = node15;
        ListNode node16 = new ListNode(5);
        node15.next = node16;
        ListNode node17 = new ListNode(9);
        node16.next = node17;
        ListNode node18 = new ListNode(20);
        node17.next = node18;
        ListNode node19 = new ListNode(14);
        node18.next = node19;
        ListNode node20 = new ListNode(14);
        node19.next = node20;
        ListNode node21 = new ListNode(2);
        node20.next = node21;
        ListNode node22 = new ListNode(13);
        node21.next = node22;
        ListNode node23 = new ListNode(-24);
        node22.next = node23;
        ListNode node24 = new ListNode(21);
        node23.next = node24;
        ListNode node25 = new ListNode(23);
        node24.next = node25;
        ListNode node26 = new ListNode(-21);
        node25.next = node26;
        ListNode node27 = new ListNode(5);
        node26.next = node27;
        node27.next = node24;
        ListNode result = new DetectCycle().detectCycle(node);
        System.out.println(result.toString());
    }

    public ListNode detectCycle(ListNode head) {
        if (Objects.isNull(head) || head.next == null) {
            return null;
        }
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while (fast != slow) {
            fast = fast == null || fast.next == null ? null : fast.next.next;
            slow = slow == null ? null : slow.next;
        }
        if (fast == null) {
            return null;
        }
        ListNode tmp = head;
        while (tmp != slow) {
            tmp = tmp.next;
            slow = slow.next;
        }
        return slow;
    }
}
