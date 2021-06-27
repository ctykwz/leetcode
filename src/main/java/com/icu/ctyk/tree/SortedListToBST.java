package com.icu.ctyk.tree;

import com.icu.ctyk.list.node.ListNode;
import com.icu.ctyk.tree.base.TreeNode;

/**
 * @author ctykwz on 2021-06-24 15:20
 */
public class SortedListToBST {


    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        node.next = new ListNode(1);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(4);
        node.next.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next.next = new ListNode(6);
        node.next.next.next.next.next.next.next = new ListNode(7);
        TreeNode root = new SortedListToBST().sortedListToBST(node);
        System.out.println(root);
    }


    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        return build(head, null);
    }

    private TreeNode build(ListNode from, ListNode end) {
        if (from == null || from == end) {
            return null;
        }
        ListNode mid = midNode(from, end);
        TreeNode node = new TreeNode(mid.val);
        TreeNode left = build(from, mid);
        TreeNode right = build(mid.next, end);
        node.left = left;
        node.right = right;
        return node;
    }

    private ListNode midNode(ListNode head, ListNode end) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null && fast.next != end && fast != end) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
