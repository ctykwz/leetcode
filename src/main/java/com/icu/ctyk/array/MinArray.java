package com.icu.ctyk.array;

/**
 * @author ctykwz on 2021-06-12 14:28
 */
public class MinArray {

    public static void main(String[] args) {
        int cnt = new MinArray().minArray(new int[]{5,6,7,0,1,2,3});
        System.out.println(cnt);
    }

    public int minArray(int[] numbers) {
        if (numbers == null) {
            return 0;
        }
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            // 主要怕right+left溢出
            int mid = left + (right - left) / 2;
            if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else if ((numbers[mid] < numbers[right])) {
                right = mid;
            } else {
                left++;
            }
        }
        return numbers[left];
    }
}
