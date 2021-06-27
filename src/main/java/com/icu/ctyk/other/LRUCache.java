package com.icu.ctyk.other;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ctykwz on 2021-06-16 20:28
 */
public class LRUCache {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.get(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);
        cache.put(3, 3);
        cache.get(2);
        cache.put(4, 4);
        cache.get(1);
        cache.get(3);
        cache.get(4);
    }

    private final Map<Integer, DataNode> keyNodeMap = new HashMap<>();
    private final DataNode head;
    private final DataNode tail;
    private final int capacity;
    private int count = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DataNode();
        tail = new DataNode();
        head.next = tail;
        tail.pre = head;
    }

    public Integer get(Integer key) {
        if (!keyNodeMap.containsKey(key)) {
            return -1;
        }
        DataNode node = keyNodeMap.get(key);
        moveToHead(node);
        return node.value;
    }

    public void put(Integer key, Integer value) {
        if (!keyNodeMap.containsKey(key)) {
            DataNode realHead = head.next;
            DataNode node = new DataNode(head, realHead, key, value);
            realHead.pre = node;
            head.next = node;
            node.pre = head;
            node.next = realHead;
            keyNodeMap.put(key, node);
            count++;
            if (count > capacity) {
                deleteTail();
                count--;
            }
        } else {
            DataNode node = keyNodeMap.get(key);
            node.value = value;
            moveToHead(node);
        }
    }

    private void deleteTail() {
        if (this.tail.pre == null || this.tail.pre.value == null) {
            return;
        }
        keyNodeMap.remove(this.tail.pre.key);
        DataNode pre = tail.pre.pre;
        pre.next = tail;
        tail.pre = pre;
    }

    private void moveToHead(DataNode node) {
        DataNode pre = node.pre;
        DataNode next = node.next;
        next.pre = pre;
        pre.next = next;
        DataNode cur = head.next;
        cur.pre = node;
        head.next = node;
        node.pre = head;
        node.next = cur;
    }


    private static class DataNode {
        DataNode pre;
        DataNode next;
        Integer key;
        Integer value;

        public DataNode() {
        }

        public DataNode(DataNode pre, DataNode next, Integer key, Integer value) {
            this.pre = pre;
            this.next = next;
            this.key = key;
            this.value = value;
        }
    }
}
