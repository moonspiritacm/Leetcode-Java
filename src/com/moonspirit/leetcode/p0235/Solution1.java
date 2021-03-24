package com.moonspirit.leetcode.p0235;

import java.util.ArrayList;
import java.util.List;

/**
 * 两趟遍历，先记录搜索路径，再找到分岔点。O(n) O(1)
 * 利用二叉搜索树顺序特征，判断节点搜索路径。
 */
class Solution1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }

        List<TreeNode> pList = new ArrayList<>();
        List<TreeNode> qList = new ArrayList<>();
        TreeNode curr = root;
        while (curr != null) {
            pList.add(curr);
            if (curr.val > p.val) {
                curr = curr.left;
            } else if (curr.val < p.val) {
                curr = curr.right;
            } else {
                break;
            }
        }
        curr = root;
        while (curr != null) {
            qList.add(curr);
            if (curr.val > q.val) {
                curr = curr.left;
            } else if (curr.val < q.val) {
                curr = curr.right;
            } else {
                break;
            }
        }
        TreeNode res = null;
        for (int i = 0; i < pList.size() && i < qList.size(); i++) {
            if (pList.get(i) != qList.get(i)) {
                break;
            } else {
                res = pList.get(i);
            }
        }
        return res;
    }
}
