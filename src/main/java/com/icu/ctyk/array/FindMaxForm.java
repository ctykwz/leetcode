package com.icu.ctyk.array;

/**
 * @author ctykwz on 2021-06-06 15:37
 */
public class FindMaxForm {

    // strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
    public int findMaxForm(String[] strs, int m, int n) {
        if (strs == null || strs.length == 0) {
            return 0;
        }
        // i个0、j个1的最大子集的大小
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int zeroCnt = 0;
            int oneCnt = 0;
            for (char c : str.toCharArray()) {
                if (c == '0') {
                    zeroCnt++;
                } else {
                    oneCnt++;
                }
            }
            for (int i = m; i >= zeroCnt; i--) {
                for (int j = n; j >= oneCnt; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroCnt][j - oneCnt] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
