package com.moonspirit.leetcode.p0589;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 迭代。O(N) O(N-1)
 */
class Solution {
    public List<Integer> preorder(Node root) {
        if(root==null) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        Stack<Node> stk = new Stack<>();
        stk.push(root);
        while(!stk.isEmpty()) {
            Node node = stk.pop();
            res.add(node.val);
            for(int i=node.children.size()-1;i>=0;i--) {
                stk.push(node.children.get(i));
            }
        }
        return res;
    }
}
