package com.moonspirit.leetcode.p0648;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 前缀树。O(n) O(n)
 */
class Trie {
    private Map<Character, Trie> children;
    private boolean isLeaf;
    private String word;

    public Trie() {
        this.children = new HashMap<>();
        this.isLeaf = false;
        this.word = null;
    }

    public void insert(String word) {
        Trie node = this;
        char[] chs = word.toCharArray();
        for (char ch : chs) {
            if (!node.children.containsKey(ch)) {
                node.children.put(ch, new Trie());
            }
            node = node.children.get(ch);
        }
        node.isLeaf = true;
        node.word = word;
    }

    public String searchRoot(String word) {
        Trie node = this;
        char[] chs = word.toCharArray();
        for (char ch : chs) {
            if (node.isLeaf) {
                return node.word;
            } else if (!node.children.containsKey(ch)) {
                return null;
            }
            node = node.children.get(ch);
        }
        return node.word;
    }
}

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        if (dictionary == null || dictionary.size() == 0 || sentence == null || sentence.length() == 0) {
            return sentence;
        }

        Trie trie = new Trie();
        for (String str : dictionary) {
            trie.insert(str);
        }

        StringBuilder sb = new StringBuilder();
        String[] strs = sentence.split("\\s+");
        for (String str : strs) {
            String root = trie.searchRoot(str);
            if (root == null) {
                sb.append(str);
            } else {
                sb.append(root);
            }
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
