package com.icu.ctyk.list.node;

import java.util.Stack;

/**
 * @author ctykwz on 2021-06-20 21:54
 */
public class ReversePrint {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> res = new Stack<>();
        while (head != null) {
            res.push(head.val);
            head = head.next;
        }
        int[] resArr = new int[res.size()];
        int i = 0;
        while (!res.isEmpty()) {
            resArr[i++] = res.pop();
        }
        return resArr;
    }
}
