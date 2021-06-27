package com.icu.ctyk.array;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author ctykwz on 2021-06-16 23:14
 */
public class FindCardLocation {

    public static void main(String[] args) {
        System.out.println(new FindCardLocation().findCardLocation(new int[]{6, 2, 4, 7, 5, 3, 1}));
    }

    /**
     * 1. 从牌顶拿出一张牌，放到桌子上
     * 2. 从牌顶拿出一张牌，放在牌的底部
     * 3. 重复第一步，第二步操作，知道所有的牌都放到了桌子上
     * 问：已知桌子上牌的顺序是1,2,3,4,5,6,7,8,9,10,11,12,13
     * 牌原来的顺序是什么
     * 假如说原来的牌是 1,2,3,4,5,6,7
     * 1 余 3,4,5,6,7,2  ——> 3,1 余 5,6,7,2,4 -> 5,3,1 余 7,2,4,6 -》7,5,3,1 余 4,6,2 -》 4,7,5,3,1 余 2,6
     * -》 2,4,7,5,3,1 余6 -》 6,2,4,7,5,3,1
     * 回放
     * @param nums
     * @return
     */
    public LinkedBlockingDeque<Integer> findCardLocation(int[] nums) {
        if (nums == null) {
            return new LinkedBlockingDeque<>(0);
        }
        LinkedBlockingDeque<Integer> deque = new LinkedBlockingDeque<>();
        for (int num : nums) {
            if (!deque.isEmpty()) {
                deque.addFirst(deque.removeLast());
            }
            deque.addFirst(num);
        }
        return deque;
    }
}
