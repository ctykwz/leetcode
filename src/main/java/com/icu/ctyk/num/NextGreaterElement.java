package com.icu.ctyk.num;

/**
 * @author ctykwz on 2021-06-24 09:44
 */
public class NextGreaterElement {

    public static void main(String[] args) {
        System.out.println(new NextGreaterElement().nextGreaterElement(2147483486));
    }

    public int nextGreaterElement(int n) {
        char[] tmp = String.valueOf(n).toCharArray();

        //本质上只要从右侧找第一个递减序列就行
        int left = tmp.length - 2;
        while (left >= 0 && tmp[left + 1] <= tmp[left]) {
            left--;
        }
        if (left < 0) {
            return -1;
        }
        int right = tmp.length;
        for (int i = tmp.length - 1; i > left; i--) {
            if (tmp[i] > tmp[left]) {
                right = i;
                break;
            }
        }
        swap(tmp, left, right);
        revert(tmp, left + 1, tmp.length - 1);
        try {
            return Integer.parseInt(new String(tmp));
        } catch (Exception e) {
            return -1;
        }
    }

    private void revert(char[] nums, int from, int to) {
        while (from < to) {
            swap(nums, from, to);
            from++;
            to--;
        }
    }

    private void swap(char[] nums, int left, int right) {
        char tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
