package com.icu.ctyk.str;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ctykwz on 2021-06-28 16:37
 */
public class PartitionLabels {

    public static void main(String[] args) {
        System.out.println(new PartitionLabels().partitionLabels("ababcbacadefegdehijhklij"));
    }

    public List<Integer> partitionLabels(String s) {
        int[] container = new int[26];
        for (int i = 0; i < s.length(); i++) {
            container[s.charAt(i) - 'a'] = i;
        }
        int start = 0;
        int end = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, container[s.charAt(i) - 'a']);
            if (end == i) {
                res.add(end - start + 1);
                System.out.println(s.substring(start, end));
                start = end + 1;
            }
        }
        return res;
    }
}
