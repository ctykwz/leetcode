package com.icu.ctyk.array;

/**
 * @author ctykwz on 2021-06-24 10:49
 */
public class MergeArray {
    public static void main(String[] args) {
        new MergeArray().merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
    }

    public void merge(int[] A, int m, int[] B, int n) {
        int tailA = m - 1;
        int tailB = n - 1;
        int index = m + n - 1;
        while (tailA >= 0 || tailB >= 0) {
            if (tailA >= 0 && tailB >= 0 && A[tailA] > B[tailB] || tailA >= 0 && tailB < 0) {
                A[index] = A[tailA];
                tailA--;
            } else {
                A[index] = B[tailB];
                tailB--;
            }
            --index;
        }
    }
}
