package com.icu.ctyk.list.node;

/**
 * @author ctykwz on 2021-06-20 15:02
 */
public class MergeTwoLists25 {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        node.next = node1;
        node1.next = node2;
        node3.next = node4;
        node4.next = node5;
        ListNode result = new MergeTwoLists25().mergeTwoLists(node, node3);
        System.out.println(result);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode primary = l1.val > l2.val ? l2 : l1;
        ListNode checker = l1 == primary ? l2 : l1;
        ListNode tmp = primary;
        while (checker != null) {
            while (tmp.next != null && tmp.next.val < checker.val) {
                tmp = tmp.next;
            }
            ListNode next = tmp.next;
            ListNode nextC = checker.next;
            tmp.next = checker;
            tmp = tmp.next;
            tmp.next = next;
            checker = nextC;
        }
        return primary;
    }
}
