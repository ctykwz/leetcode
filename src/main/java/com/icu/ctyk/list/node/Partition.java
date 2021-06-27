package com.icu.ctyk.list.node;

/**
 * @author ctykwz on 2021-06-22 09:41
 */
public class Partition {

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
        ListNode result = new Partition().partition(node, 3);
        System.out.println(result.toString());
    }

    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode();
        ListNode large = new ListNode();
        ListNode sTmp = small;
        ListNode lTemp = large;
        while (head != null) {
            ListNode next = head.next;
            if (head.val < x) {
                sTmp.next = head;
                sTmp = sTmp.next;
                sTmp.next = null;
            } else {
                lTemp.next = head;
                lTemp = lTemp.next;
                lTemp.next = null;
            }
            head = next;
        }
        if (small.next == null) {
            return large.next;
        }
        if (large.next == null) {
            return small.next;
        }
        sTmp.next = large.next;
        return small.next;
    }
}
