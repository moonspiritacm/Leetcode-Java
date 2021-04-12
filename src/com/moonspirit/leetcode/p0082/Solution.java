package com.moonspirit.leetcode.p0082;

/**
 * 两个变量。O(n) O(1)
 * 首元节点可能被删除，需要使用头节点。
 * prev记录前驱节点，curr记录当前节点，比对二者数值。若二者相同，删除当前节点，curr后移；若二者不同，prev和curr同步后移。
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyRoot = new ListNode();
        dummyRoot.next = head;
        ListNode prev = dummyRoot;
        ListNode curr = head;
        while (curr != null) {
            while (curr.next != null && curr.next.val == curr.val) {
                curr = curr.next;
            }
            if (prev.next != curr) {
                prev.next = curr.next;
                curr = curr.next;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return dummyRoot.next;
    }
}
