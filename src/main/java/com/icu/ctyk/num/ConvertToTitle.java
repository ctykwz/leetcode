package com.icu.ctyk.num;

/**
 * @author ctykwz on 2021-06-29 11:09
 */
public class ConvertToTitle {

    public String convertToTitle(int columnNumber) {
        if (columnNumber <= 0) {
            return "";
        }
        // 起始值为 A~Z 的26进制
        StringBuilder builder = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber = columnNumber - 1;
            builder.append((char) (columnNumber % 26 + 'A'));
            columnNumber = columnNumber / 26;
        }
        return builder.reverse().toString();
    }
}
