package com.icu.ctyk.array;

/**
 * @author ctykwz on 2021-06-20 08:53
 */
public class RemoveElement {

    public static void main(String[] args) {
        System.out.println(new RemoveElement().removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
    }

    /**
     * 0,1,2,2,3,0,4,2 -->del 2
     */
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                swap(nums, slow, i);
                slow++;
            }
        }
        return slow;
    }

    private void swap(int[] nums, int left, int right) {
        int val = nums[left];
        nums[left] = nums[right];
        nums[right] = val;
    }
}
