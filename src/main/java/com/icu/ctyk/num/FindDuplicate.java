package com.icu.ctyk.num;

/**
 * @author ctykwz on 2021-06-20 09:33
 */
public class FindDuplicate {

    public static void main(String[] args) {
        System.out.println(new FindDuplicate().findDuplicate(new int[]{1, 3, 4, 2, 2}));
    }

    // 类似于环形链表求环的入口，用快慢指针做，这里的指针前进距离用index的值
    public int findDuplicate(int[] nums) {
        int fast = 0;
        int slow = 0;
        while (true) {
            fast = nums[nums[fast]];
            slow = nums[slow];
            if (fast == slow) {
                break;
            }
        }
        int head = 0;
        while (true) {
            slow = nums[slow];
            head = nums[head];
            if (head == slow) {
                break;
            }
        }
        return head;
    }
}
