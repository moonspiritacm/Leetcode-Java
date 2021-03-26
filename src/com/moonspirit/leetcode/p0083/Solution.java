package com.moonspirit.leetcode.p0083;

/**
 * 两个变量。O(n) O(1)
 * 首元节点不会被删除，无需使用头节点。
 * prev记录前驱节点，curr记录当前节点，比对二者数值。若二者相同，删除当前节点，curr后移；若二者不同，prev和curr同步后移。
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = head;
        ListNode curr = head.next;
        while (curr != null) {
            if (prev.val == curr.val) {
                prev.next = curr.next;
                curr = curr.next;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }
}
