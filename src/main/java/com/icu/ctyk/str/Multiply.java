package com.icu.ctyk.str;

/**
 * https://leetcode-cn.com/problems/multiply-strings/solution/gao-pin-mian-shi-xi-lie-zi-fu-chuan-cheng-fa-by-la/
 *
 * @author ctykwz on 2021-06-03 21:01
 */
public class Multiply {

    public static void main(String[] args) {
        System.out.println(new Multiply().multiply("12", "12"));
    }

    // 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
    public String multiply(String num1, String num2) {
        int[] temp = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int right = i + j + 1;
                int left = i + j;
                int value = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + temp[right];
                temp[right] = value % 10;
                temp[left] += value / 10;
            }
        }
        StringBuilder result = new StringBuilder();
        boolean hasValue = false;
        for (int num : temp) {
            if (num == 0 && !hasValue) {
                continue;
            }
            hasValue = true;
            result.append(num);
        }
        return result.length() == 0 ? "0" : result.toString();
    }
}
