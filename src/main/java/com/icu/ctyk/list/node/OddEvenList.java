package com.icu.ctyk.list.node;

import java.util.Objects;

/**
 * @author ctykwz on 2021-06-03 11:49
 */
public class OddEvenList {


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
        ListNode result = new OddEvenList().oddEvenListV2(node);
        System.out.println(result.toString());
    }

    public ListNode oddEvenList(ListNode head) {
        if (Objects.isNull(head)) {
            return null;
        }
        ListNode oddNode = new ListNode(0);
        ListNode evenNode = new ListNode(0);
        int i = 1;
        ListNode odd = oddNode;
        ListNode even = evenNode;
        while (Objects.nonNull(head)) {
            if (i % 2 == 0) {
                even.next = head;
                even = even.next;
            } else {
                odd.next = head;
                odd = odd.next;
            }
            head = head.next;
            i++;
        }
        even.next = null;
        odd.next = evenNode.next;
        return oddNode.next;
    }


    public ListNode oddEvenListV2(ListNode head) {
        if (Objects.isNull(head)) {
            return null;
        }
        ListNode oddNode = head;
        ListNode evenNode = head.next;
        ListNode even = evenNode;
        while (Objects.nonNull(even) && Objects.nonNull(even.next)) {
            oddNode.next = even.next;
            oddNode = oddNode.next;
            even.next = oddNode.next;
            even=even.next;
        }
        oddNode.next = evenNode;
        return head;
    }
}
