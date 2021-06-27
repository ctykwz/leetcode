package com.icu.ctyk.other;

/**
 * @author ctykwz on 2021-06-24 09:10
 */
public class Trie {

    private final Trie[] next;
    private boolean isEnd;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        next = new Trie[26];
        isEnd = false;
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Trie node = this;
        char[] chars = word.toCharArray();
        for (char aChar : chars) {
            int index = aChar - 'a';
            if (node.next[index] == null) {
                node.next[index] = new Trie();
            }
            node = node.next[index];
        }
        node.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Trie node = findNode(word);
        return node != null && node.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Trie node = findNode(prefix);
        return node != null;
    }

    private Trie findNode(String word) {
        Trie node = this;
        char[] chars = word.toCharArray();
        for (char aChar : chars) {
            int index = aChar - 'a';
            if (node.next[index] == null) {
                return null;
            }
            node = node.next[index];
        }
        return node;
    }
}
