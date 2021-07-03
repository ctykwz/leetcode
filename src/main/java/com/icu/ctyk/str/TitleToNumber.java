package com.icu.ctyk.str;

/**
 * @author ctykwz on 2021-07-03 23:13
 */
public class TitleToNumber {

    public int titleToNumber(String columnTitle) {
        int num = 0;
        for (char token : columnTitle.toCharArray()) {
            num = num * 26 + token - 'A' + 1;
        }
        return num;
    }
}
