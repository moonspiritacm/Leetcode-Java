package com.moonspirit.leetcode.p0083;

/**
 * 一个变量。O(n) O(1)
 * 首元节点不会被删除，无需使用头节点。
 * curr记录当前节点，比对当前节点与后继节点数值。若二者相同，删除后继节点；若二者不同，curr后移。
 */
class Solution1 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode curr = head;
        while (curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }
}
