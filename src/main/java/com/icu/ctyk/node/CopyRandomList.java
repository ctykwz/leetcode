package com.icu.ctyk.node;

import com.icu.ctyk.node.base.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ctykwz on 2021-06-20 15:23
 */
public class CopyRandomList {


    public static void main(String[] args) {
        Node node = new Node(1);
        Node next = new Node(2);
        node.next = next;
        next.random = next;
        Node result = new CopyRandomList().copyRandomList(node);
        System.out.println(result);
    }

    public Node copyRandomList(Node head) {
        return getNode(head, new HashMap<>());
    }

    private Node getNode(Node from, Map<Node, Node> map) {
        if (from == null) {
            return null;
        }
        if (map.containsKey(from)) {
            return map.get(from);
        }
        Node node = new Node(from.val);
        map.put(from, node);
        node.next = getNode(from.next, map);
        node.random = getNode(from.random, map);
        return node;
    }

}
