package com.icu.ctyk.list.node;

import java.util.Stack;

/**
 * @author ctykwz on 2021-06-10 15:34
 */
public class AddTwoNumbers {


    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        node.next = node1;
        node1.next = node2;
        node3.next = node4;
        new AddTwoNumbers().addTwoNumbers(node, node3);
        System.out.println(node1);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> left = new Stack<>();
        Stack<ListNode> right = new Stack<>();
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                ListNode next = l1.next;
                left.push(l1);
                l1 = next;
            }
            if (l2 != null) {
                ListNode next = l2.next;
                right.push(l2);
                l2 = next;
            }
        }
        ListNode pre = null;
        int carry = 0;
        while (!left.isEmpty() || !right.isEmpty()) {
            int val = (left.isEmpty() ? 0 : left.pop().val) + (right.isEmpty() ? 0 : right.pop().val) + carry;
            ListNode node = new ListNode(val % 10);
            carry = val / 10;
            node.next = pre;
            pre = node;
        }
        if (carry!=0){
            ListNode node = new ListNode(carry);
            node.next = pre;
            pre = node;
        }
        return pre;
    }
}
