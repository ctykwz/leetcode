package com.icu.ctyk.num;

/**
 * @author ctykwz on 2021-07-01 10:06
 */
public class IsHappy {

    public static void main(String[] args) {
        System.out.println(new IsHappy().isHappy(3));
    }

    public boolean isHappy(int n) {
        int fast = getNext(n);
        int slow = n;
        // 结束条件是要么到根节点（1） 要么到环相交处
        while (fast != 1 && fast != slow) {
            fast = getNext(getNext(fast));
            slow = getNext(slow);
        }
        return fast == 1;
    }

    public int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int num = n % 10;
            sum += num * num;
            n = n / 10;
        }
        return sum;
    }

}
