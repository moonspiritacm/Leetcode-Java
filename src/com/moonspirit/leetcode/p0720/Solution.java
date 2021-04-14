package com.moonspirit.leetcode.p0720;

/**
 * 前缀树+深度优先搜索。O(∑w) O(∑w)
 */
class Solution {
    public String longestWord(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }

        Trie trie = new Trie();
        for (String str : words) {
            trie.insert(str);
        }
        return trie.bfs();
    }
}
