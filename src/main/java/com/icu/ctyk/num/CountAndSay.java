package com.icu.ctyk.num;

/**
 * @author ctykwz on 2021-06-23 08:48
 */
public class CountAndSay {

    public static void main(String[] args) {
        System.out.println(new CountAndSay().countAndSay(4));
    }

    public String countAndSay(int n) {
        StringBuilder cur = new StringBuilder("1");
        StringBuilder pre;

        for (int i = 1; i < n; i++) {
            pre = cur;
            cur = new StringBuilder();
            int start = 0;
            int end = 0;
            // 开始描述前面出现的数据
            while (end < pre.length()) {
                while (end < pre.length() && pre.charAt(start) == pre.charAt(end)) {
                    end++;
                }
                cur.append((end - start)).append(pre.charAt(start));
                start = end;
            }
        }
        return cur.toString();
    }

}
