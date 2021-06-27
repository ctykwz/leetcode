package com.icu.ctyk.list.node;

/**
 * @author ctykwz on 2021-06-19 11:52
 */
public class IsPalindrome {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(5);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        // node3.next = node4;
        boolean result = new IsPalindrome().isPalindrome(node);
        System.out.println(Boolean.toString(result));
    }


    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode tail = revert(slow);
        while (head != slow) {
            if (head.val != tail.val) {
                return false;
            }
            head = head.next;
            tail = tail.next;
        }
        return true;
    }

    private ListNode revert(ListNode node) {
        ListNode pre = null;
        ListNode cur = node;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
