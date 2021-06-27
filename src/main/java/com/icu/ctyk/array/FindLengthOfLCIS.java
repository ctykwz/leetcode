package com.icu.ctyk.array;

/**
 * @author ctykwz on 2021-06-06 11:13
 */
public class FindLengthOfLCIS {

    public static void main(String[] args) {
        int[] val = new int[]{1, 3, 5, 4, 7};
        System.out.println(new FindLengthOfLCIS().findLengthOfLCIS(val));
    }

    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 1;
        int start = 0;
        // 1 2 3 2 5 7
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                res = Math.max(res, i - start + 1);
            } else {
                start = i;
            }
        }
        return res;
    }

}
