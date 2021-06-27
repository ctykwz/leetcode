package com.icu.ctyk.list.node;

import com.icu.ctyk.list.node.ListNode;

import java.util.List;
import java.util.Objects;

/**
 * @author ctykwz on 2021-06-04 12:05
 */
public class ReorderList {

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
        new ReorderList().reorderList(node);
        System.out.println(node1);
    }

    public void reorderList(ListNode head) {
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return;
        }
        // 先找中心节点
        ListNode slow = head;
        ListNode fast = head.next;
        while (Objects.nonNull(slow) && Objects.nonNull(fast)) {
            slow = slow.next;
            fast = Objects.isNull(fast.next) ? null : fast.next.next;
        }
        // slow就是中心节点 revert下后续的节点
        ListNode right = revert(slow);
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tmp = dummy.next;
        while (!Objects.equals(slow, right) ) {
            ListNode leftNext = tmp.next;
            tmp.next = right;
            right = Objects.isNull(right) ? null : right.next;
            tmp = tmp.next;
            tmp.next = leftNext;
            tmp = tmp.next;
        }
    }

    private ListNode revert(ListNode root) {
        if (Objects.isNull(root)) {
            return null;
        }
        ListNode pre = null;
        ListNode cur = root;
        while (Objects.nonNull(cur)) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
