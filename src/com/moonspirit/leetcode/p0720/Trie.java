package com.moonspirit.leetcode.p0720;

import java.util.*;

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

    public String bfs() {
        this.isLeaf = true;
        this.word = "";

        String res = "";
        Queue<Trie> queue = new LinkedList<>();
        queue.offer(this);
        while (!queue.isEmpty()) {
            Trie node = queue.poll();
            if (node.isLeaf) {
                if (node.word.length() > res.length() || node.word.length() == res.length() && node.word.compareTo(res) < 0) {
                    res = node.word;
                }
                for (Trie trie : node.children.values()) {
                    queue.offer(trie);
                }
            }
        }
        return res;
    }

    public String dfs() {
        this.isLeaf = true;
        this.word = "";

        String res = "";
        Stack<Trie> stk = new Stack<>();
        stk.push(this);
        while (!stk.isEmpty()) {
            Trie node = stk.pop();
            if (node.isLeaf) {
                if (node.word.length() > res.length() || node.word.length() == res.length() && node.word.compareTo(res) < 0) {
                    res = node.word;
                }
                for (Trie trie : node.children.values()) {
                    stk.push(trie);
                }
            }
        }
        return res;
    }
}
