package com.icu.ctyk.tree;

/**
 * @author ctykwz on 2021-06-20 19:54
 */
public class TreeToDoublyList {

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        System.out.println(new TreeToDoublyList().treeToDoublyList(root));
    }

    private Node pre;
    private Node head;

    public Node treeToDoublyList(Node root) {
        head = null;
        pre = null;
        dfs(root);
        if (head == null) {
            return null;
        }
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void dfs(Node root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (head == null) {
            head = root;
            pre = head;
        } else {
            pre.right = root;
            root.left = pre;
            pre = root;
        }
        dfs(root.right);
    }


    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    ;
}
