package com.icu.ctyk.tree;

/**
 * @author ctykwz on 2021-07-02 11:03
 */
public class IsValidSerialization {

    public static void main(String[] args) {
        Boolean res = new IsValidSerialization().isValidSerialization("9,#,#,1");
        System.out.println(res);
    }

    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0) {
            return true;
        }
        int index = 0;
        // 第一个合法的是数字 也就是有一个节点
        int leaf = 1;
        while (index < preorder.length()) {
            if (leaf == 0) {
                // 还没遍历完就已经没节点了
                return false;
            }
            if (preorder.charAt(index) == ',') {
                index += 1;
            } else if (preorder.charAt(index) == '#') {
                // 填充位没有子节点
                index += 1;
                leaf -= 1;
            } else {
                // number 可能存在子节点
                while (index < preorder.length() && preorder.charAt(index) != ',') {
                    // 数字是合法的，不会出现数字后是#的
                    index += 1;
                }
                // 减去当前节点，添加两个节点
                leaf += 1;
            }
        }
        return leaf == 0;
    }
}
