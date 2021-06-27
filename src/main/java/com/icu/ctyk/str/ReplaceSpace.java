package com.icu.ctyk.str;

/**
 * @author ctykwz on 2021-06-20 21:12
 */
public class ReplaceSpace {

    public String replaceSpace(String s) {
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                builder.append("%20");
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }
}
