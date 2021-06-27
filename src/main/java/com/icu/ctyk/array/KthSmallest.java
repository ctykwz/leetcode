package com.icu.ctyk.array;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/
 * n == matrix.length
 * n == matrix[i].length
 * 1 <= n <= 300
 * -109 <= matrix[i][j] <= 109
 * 题目数据 保证 matrix 中的所有行和列都按 非递减顺序 排列
 * 1 <= k <= n2
 *
 * @author ctykwz on 2021-06-27 15:58
 */
public class KthSmallest {

    public static void main(String[] args) {
        System.out.println(
                new KthSmallest().kthSmallestV2(
                        new int[][]{
                                new int[]{1, 2},
                                new int[]{1, 5}
                        },
                        3
                )
        );
    }

    public int kthSmallest(int[][] matrix, int k) {
        // row,col,val
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(it -> it[2]));

        for (int row = 0; row < matrix.length; row++) {
            int[] tmp = new int[]{row, 0, matrix[row][0]};
            queue.offer(tmp);
        }
        for (int i = 0; i < k - 1; ++i) {
            int[] val = queue.poll();
            if (val != null && val[1] != matrix.length - 1) {
                queue.offer(new int[]{val[0], val[1] + 1, matrix[val[0]][val[1] + 1]});
            }
        }
        return queue.isEmpty() ? -1 : queue.poll()[2];
    }


    public int kthSmallestV2(int[][] matrix, int k) {
        int len = matrix.length;
        int right = matrix[len - 1][len - 1];
        int left = matrix[0][0];
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (greatThan(matrix, mid, len, k)) {
                // 小于mid的量大于k
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean greatThan(int[][] matrix, int mid, int len, int k) {
        int cnt = 0;
        int row = len - 1;
        int col = 0;
        while (row >= 0 && col < len) {
            if (matrix[row][col] <= mid) {
                // 按列计算，当数符合预期时，当前列满足的量为 i+1 ，因为列递增和行递增，所以row 减小时还是小于mid
                cnt += row + 1;
                col++;
            } else {
                row--;
            }
        }
        return cnt >= k;
    }

}
