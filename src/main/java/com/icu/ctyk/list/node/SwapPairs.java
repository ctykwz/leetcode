package com.icu.ctyk.list.node;

/**
 * @author ctykwz on 2021-06-19 08:50
 */
public class SwapPairs {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        // node3.next = node4;
        ListNode result = new SwapPairs().swapPairs(node);
        System.out.println(result.toString());
    }

    public ListNode swapPairsV3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairsV3(head.next.next);
        newHead.next = head;
        return newHead;
    }

    public ListNode swapPairsV2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode tmp = dummy;
        while (tmp.next != null && tmp.next.next != null) {
            // 1->2->3->4           3->4
            ListNode first = tmp.next;
            // 2-3->4         4
            ListNode sec = tmp.next.next;
            tmp.next = sec;
            // 1->3->4
            first.next = sec.next;
            // 2->1->3->4
            sec.next = first;
            tmp = first;
        }
        return dummy.next;
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode();
        ListNode tmp = dummy;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null || slow != null) {
            ListNode slowNode = slow;
            ListNode fastNode = fast;
            slow = slow == null || slow.next == null ? null : slow.next.next;
            fast = fast == null || fast.next == null ? null : fast.next.next;
            if (fastNode != null) {
                tmp.next = fastNode;
                tmp = tmp.next;
            }
            if (slowNode != null) {
                tmp.next = slowNode;
                tmp = tmp.next;
            }
        }
        return dummy.next;
    }
}
