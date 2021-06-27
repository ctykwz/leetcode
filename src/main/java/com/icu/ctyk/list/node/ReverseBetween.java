package com.icu.ctyk.list.node;

import java.util.Objects;

/**
 * @author ctykwz on 2021-06-04 15:26
 */
public class ReverseBetween {

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
        ListNode result = new ReverseBetween().reverseBetween(node, 2, 3);
        System.out.println(result.toString());
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (Objects.isNull(head) || left > right) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode preNode = dummy;
        for (int i = 0; i < left - 1; i++) {
            preNode = preNode.next;
        }
        ListNode tailNode = preNode;
        for (int i = 0; i < right - left + 1; i++) {
            tailNode = tailNode.next;
        }
        ListNode center = preNode.next;
        ListNode tail = tailNode.next;
        preNode.next = null;
        tailNode.next = null;
        // revert 后 原链表的 tail变成head 原来的head变成tail，所以之前pre链接tail（center.next），原来的center.head连接tail
        revert(center);
        preNode.next = tailNode;
        center.next = tail;
        return dummy.next;
    }

    private void revert(ListNode root) {
        ListNode pre = null;
        ListNode cur = root;
        while (Objects.nonNull(cur)) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }
}
