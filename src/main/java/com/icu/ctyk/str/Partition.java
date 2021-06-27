package com.icu.ctyk.str;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ctykwz on 2021-06-05 14:28
 */
public class Partition {


    public static void main(String[] args) {
        System.out.println(new Partition().partitionV2("aab"));
    }

    public List<List<String>> partitionV2(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        // 从i到j的字符串是否为回文串
        boolean[][] dp = new boolean[s.length()][s.length()];
        int strLength = s.length();
        for (int j = 0; j < strLength; j++) {
            for (int i = j; i >= 0; i--) {
                if (i == j) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = (j - i == 1 || dp[i + 1][j - 1]) && s.charAt(i) == s.charAt(j);
                }
            }
        }
        List<List<String>> result = new ArrayList<>();
        List<String> tmp = new ArrayList<>();
        dfs(result, tmp, dp, s, 0);
        return result;
    }


    void dfs(List<List<String>> result, List<String> cur, boolean[][] dp, String str, int start) {
        if (start == str.length()) {
            result.add(new ArrayList<>(cur));
        }
        for (int i = start; i < str.length(); i++) {
            if (dp[start][i]) {
                cur.add(str.substring(start, i + 1));
                dfs(result, cur, dp, str, i + 1);
                cur.remove(cur.size() - 1);
            }
        }
    }

}
