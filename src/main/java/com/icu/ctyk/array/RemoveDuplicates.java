package com.icu.ctyk.array;

/**
 * @author ctykwz on 2021-06-05 22:30
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int fast = 1;
        int slow = 1;
        while (fast < nums.length) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicates().removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }

    // https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
    public int removeDuplicatesV2(int[] nums) {
        return remove(nums, 2);
    }

    private int remove(int[] nums, int k) {
        if (nums.length <= k) {
            return nums.length;
        }
        int index = k;
        for (int i = k; i < nums.length; i++) {
            if (nums[i] != nums[index - k]) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}
