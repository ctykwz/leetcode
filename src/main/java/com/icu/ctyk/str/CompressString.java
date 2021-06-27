package com.icu.ctyk.str;

/**
 * @author ctykwz on 2021-06-26 16:21
 */
public class CompressString {

    public static void main(String[] args) {
        System.out.println(new CompressString().compressString("aabcccccaaa"));
    }

    public String compressString(String s) {
        StringBuilder builder = new StringBuilder();
        int slow = 0;
        int index = 0;
        while (index < s.length()) {
            if (slow != index && s.charAt(index) != s.charAt(slow)) {
                builder.append(s.charAt(slow)).append(index - slow);
                slow = index;
            }
            index++;
        }
        builder.append(s.charAt(slow)).append(index - slow);
        return builder.length() == s.length() ? s : builder.toString();
    }
}
