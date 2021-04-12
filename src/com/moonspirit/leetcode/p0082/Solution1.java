package com.moonspirit.leetcode.p0082;

/**
 * 一个变量。O(n) O(1)
 * 首元节点可能被删除，需要使用头节点。
 * curr记录当前节点，比对后继节点与后后继节点数值。若二者相同，记录该数值，循环删除后继节点，直到数值不同节点或链表尾部；若二者不同，curr后移。
 */
class Solution1 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyRoot = new ListNode();
        dummyRoot.next = head;
        ListNode curr = dummyRoot;
        while (curr.next != null && curr.next.next != null) {
            if (curr.next.val == curr.next.next.val) {
                int val = curr.next.val;
                while (curr.next != null && curr.next.val == val) {
                    curr.next = curr.next.next;
                }
            } else {
                curr = curr.next;
            }
        }
        return dummyRoot.next;
    }
}
