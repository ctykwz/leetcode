package com.icu.ctyk.list.node;

import java.util.Objects;

/**
 * @author ctykwz on 2021-06-04 10:54
 */
public class GetIntersectionNode {


    //给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (Objects.isNull(headA) || Objects.isNull(headB)) {
            return null;
        }
        ListNode movA = headA;
        ListNode movB = headB;
        while (!Objects.equals(movA, movB)) {
            movA = Objects.isNull(movA.next) ? headB : movA.next;
            movB = Objects.isNull(movB.next) ? headA : movB.next;
        }
        return movA;
    }
}
