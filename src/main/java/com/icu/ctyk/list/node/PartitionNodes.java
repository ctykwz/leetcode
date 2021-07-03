package com.icu.ctyk.list.node;

import java.util.List;

/**
 * @author ctykwz on 2021-07-03 21:00
 */
public class PartitionNodes {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(2);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode result = new PartitionNodes().partition(node, 3);
        System.out.println(result.toString());
    }

    public ListNode partition(ListNode head, int x) {
        ListNode littler = new ListNode();
        ListNode bigger = new ListNode();
        ListNode big = bigger;
        ListNode little = littler;
        while (head != null) {
            ListNode next = head.next;
            if (head.val < x) {
                little.next = head;
                little = little.next;
            } else {
                big.next = head;
                big = big.next;
            }
            head = next;
        }
        big.next = null;
        little.next = bigger.next;
        return littler.next;
    }
}
