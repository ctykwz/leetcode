package com.icu.ctyk.num;

/**
 * @author ctykwz on 2021-06-17 20:47
 */
public class FindKthNumber {

    public static void main(String[] args) {
        System.out.println(new FindKthNumber().findKthNumber(100, 90));
    }

    public int findKthNumber(int n, int k) {
        if (k <= 0 || k > n) {
            return 0;
        }
        int left = 1;
        k--;
        while (k > 0) {
            int fullCnt = countFullNode(n, left, left + 1);
            if (fullCnt > k) {
                // 在子节点
                left *= 10;
                k--;
            } else {
                // 节点以下的数据量不足，在当前节点的右侧
                left += 1;
                k -= fullCnt;
            }
        }
        return left;
    }

    /**
     * 计算从 left->right 这个区间里所有的节点数
     */
    private int countFullNode(int n, long left, int right) {
        int cnt = 0;
        while (left <= n) {
            // n=15 当left=1 right=2时 在第二次循环时 right=20,此时cnt应该加 n-left+1 即 n+1-left
            cnt += Math.min(n + 1, right) - left;
            left *= 10;
            right *= 10;
        }
        return cnt;
    }

    /**
     * 会超时
     *
     * @param n
     * @param k
     * @return
     */
    public int findKthNumberV1(int n, int k) {
        if (k <= 0 || k > n) {
            return 0;
        }
        int[] res = new int[]{0, --k};
        for (int i = 1; i <= 9; i++) {
            res = dfsFind(i, n, res[1]);
            if (res[0] > 0) {
                break;
            }
        }
        return res[0];
    }

    private int[] dfsFind(int start, int n, int k) {
        if (k == 0) {
            return new int[]{start, k};
        }
        //System.out.println(start + "\t" + (681692778 - k));
        k--;
        int[] res = new int[]{-1, k};
        for (int i = 0; i <= 9; i++) {
            int val = start * 10 + i;
            if (val > n || val <= 0) {
                break;
            }
            res = dfsFind(val, n, res[1]);
            if (res[0] > 0) {
                break;
            }
        }
        return res;
    }
}
