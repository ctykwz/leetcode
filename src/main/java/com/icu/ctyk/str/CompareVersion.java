package com.icu.ctyk.str;

/**
 * @author ctykwz on 2021-06-27 21:18
 */
public class CompareVersion {

    public static void main(String[] args) {
        System.out.println(new CompareVersion().compareVersion("1.0", "1.0.1"));
    }

    public int compareVersion(String version1, String version2) {
        int index1 = 0;
        int index2 = 0;
        while (version1.length() > index1 || version2.length() > index2) {
            int[] no1Pair = parseNo(version1, index1);
            int[] no2Pair = parseNo(version2, index2);
            index1 = no1Pair[0];
            index2 = no2Pair[0];
            if (no1Pair[1] != no2Pair[1]) {
                return no1Pair[1] > no2Pair[1] ? 1 : -1;
            }
        }
        return 0;
    }

    private int[] parseNo(String version, int start) {
        if (start < 0 || start >= version.length()) {
            return new int[]{start, 0};
        }
        int index = start;
        StringBuilder builder = new StringBuilder();
        for (int i = start; i < version.length(); i++) {
            index = index + 1;
            if (version.charAt(i) == '.') {
                break;
            }
            builder.append(version.charAt(i));
        }
        return new int[]{index, builder.length() == 0 ? 0 : Integer.parseInt(builder.toString())};
    }

}
