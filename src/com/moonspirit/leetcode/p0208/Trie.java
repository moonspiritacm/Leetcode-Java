package com.moonspirit.leetcode.p0208;

/**
 * 固定长度数组。
 * 时间复杂度：O(|S|)，每次插入或查询的字符串长度；
 * 空间复杂度：O(Σ|S|)，字符串长度之和。
 */
class Trie {
    private Trie[] children;
    private boolean isLeaf;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        this.children = new Trie[26];
        this.isLeaf = false;
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Trie node = this;
        char[] chs = word.toCharArray();
        for (char ch : chs) {
            if (node.children[ch - 'a'] == null) {
                node.children[ch - 'a'] = new Trie();
            }
            node = node.children[ch - 'a'];
        }
        node.isLeaf = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isLeaf;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private Trie searchPrefix(String prefix) {
        Trie node = this;
        char[] chs = prefix.toCharArray();
        for (char ch : chs) {
            if (node.children[ch - 'a'] == null) {
                return null;
            }
            node = node.children[ch - 'a'];
        }
        return node;
    }
}
