package com.icu.ctyk.num;

/**
 * @author ctykwz on 2021-06-20 17:52
 */
public class MaximumSwap670 {

    public static void main(String[] args) {
        System.out.println(new MaximumSwap670().maximumSwap(98368));
    }

    public int maximumSwap(int num) {
        char[] value = String.valueOf(num).toCharArray();
        int[] maxIndex = new int[value.length];
        int maxIndexValue = value.length - 1;
        for (int i = value.length - 1; i >= 0; i--) {
            if (value[maxIndexValue] < value[i]) {
                maxIndexValue = i;
            }
            maxIndex[i] = maxIndexValue;
        }
        for (int i = 0; i < value.length; i++) {
            if (i < maxIndex[i] && value[i] != value[maxIndex[i]]) {
                char tmp = value[i];
                value[i] = value[maxIndex[i]];
                value[maxIndex[i]] = tmp;
                break;
            }
        }
        return Integer.parseInt(new String(value));
    }
}
