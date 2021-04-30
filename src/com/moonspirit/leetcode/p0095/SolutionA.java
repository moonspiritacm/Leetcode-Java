package com.moonspirit.leetcode.p0095;

import java.util.ArrayList;
import java.util.List;

class SolutionA {
    private List<TreeNode> backtrace(int l, int r) {
        List<TreeNode> res = new ArrayList<>();
        if (l > r) {
            res.add(null);
            return res;
        }

        for (int i = l; i <= r; i++) {
            List<TreeNode> ls = backtrace(l, i - 1);
            List<TreeNode> rs = backtrace(i + 1, r);
            for (TreeNode left : ls) {
                for (TreeNode right : rs) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    res.add(node);
                }
            }
        }
        return res;
    }

    public List<TreeNode> generateTrees(int n) {
        if (n < 1) {
            return new ArrayList<>();
        }

        return backtrace(1, n);
    }
}
