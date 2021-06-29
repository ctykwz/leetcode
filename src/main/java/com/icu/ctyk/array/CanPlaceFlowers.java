package com.icu.ctyk.array;

/**
 * @author ctykwz on 2021-06-29 17:00
 */
public class CanPlaceFlowers {


    public static void main(String[] args) {
        System.out.println(new CanPlaceFlowers().canPlaceFlowers(new int[]{1, 0, 0, 0, 0, 1}, 2));
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed == null || flowerbed.length == 0 || n <= 0) {
            return true;
        }
        int zero = 1;
        for (int token : flowerbed) {
            if (token == 0) {
                zero += 1;
            } else {
                n -= (zero - 1) / 2;
                if (n <= 0) {
                    return true;
                }
                zero = 0;
            }
        }
        zero += 1;
        n -= (zero - 1) / 2;
        return n <= 0;
    }
}
