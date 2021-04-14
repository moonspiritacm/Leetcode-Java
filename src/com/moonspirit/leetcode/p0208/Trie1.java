package com.moonspirit.leetcode.p0208;

import java.util.HashMap;
import java.util.Map;

/**
 * 哈希表。O(|S|) O(Σ|T|)
 * 使用哈希表，在空间复杂度上略有优化。
 */
class Trie1 {
    private Map<Character, Trie1> children;
    private boolean isLeaf;

    /**
     * Initialize your data structure here.
     */
    public Trie1() {
        this.children = new HashMap<>();
        this.isLeaf = false;
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Trie1 node = this;
        char[] chs = word.toCharArray();
        for (char ch : chs) {
            if (!node.children.containsKey(ch)) {
                node.children.put(ch, new Trie1());
            }
            node = node.children.get(ch);
        }
        node.isLeaf = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Trie1 node = searchPrefix(word);
        return node != null && node.isLeaf;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private Trie1 searchPrefix(String prefix) {
        Trie1 node = this;
        char[] chs = prefix.toCharArray();
        for (char ch : chs) {
            if (!node.children.containsKey(ch)) {
                return null;
            }
            node = node.children.get(ch);
        }
        return node;
    }
}
