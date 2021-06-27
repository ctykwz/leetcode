package com.icu.ctyk.array;

/**
 * @author ctykwz on 2021-06-17 22:35
 */
public class FindMedianSortedArrays {

    public static void main(String[] args) {
        System.out.println(new FindMedianSortedArrays().findMedianSortedArrays(
                new int[]{1, 2},
                new int[]{3, 4}
        ));
    }


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int pre = -1;
        int cur = -1;
        int leftIndex = 0;
        int rightIndex = 0;
        int mid = (nums1.length + nums2.length) / 2;
        for (int i = 0; i <= mid; i++) {
            pre = cur;
            if (leftIndex < nums1.length && (rightIndex >= nums2.length || nums1[leftIndex] < nums2[rightIndex])) {
                cur = nums1[leftIndex++];
            } else {
                cur = nums2[rightIndex++];
            }
        }
        if ((nums1.length + nums2.length) % 2 == 0) {
            return (pre + cur) / 2.0;
        }
        return cur;
    }
}
