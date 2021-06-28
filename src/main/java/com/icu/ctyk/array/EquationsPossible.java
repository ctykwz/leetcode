package com.icu.ctyk.array;

/**
 * @author ctykwz on 2021-06-28 18:23
 */
public class EquationsPossible {

    public static void main(String[] args) {
        System.out.println(
                new EquationsPossible().equationsPossible(
                        new String[]{
                                "a==b",
                                "b==c",
                                "c==d",
                                "d==e",
                                "a==e"
                        }
                )
        );
    }

    public boolean equationsPossible(String[] equations) {
        int[] parent = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }

        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                int left = equation.charAt(0) - 'a';
                int right = equation.charAt(3) - 'a';
                union(parent, left, right);
            }
        }
        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                int left = equation.charAt(0) - 'a';
                int right = equation.charAt(3) - 'a';
                if (find(parent, left) == find(parent, right)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void union(int[] parent, int left, int right) {
        parent[find(parent, left)] = find(parent, right);
    }

    private int find(int[] parent, int index) {
        while (parent[index] != index) {
            parent[index] = parent[parent[index]];
            index = parent[index];
        }
        return index;
    }
}
