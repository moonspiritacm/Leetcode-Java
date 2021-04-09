package com.moonspirit.nowcode.p022;

/**
 * 两趟遍历。O(n) O(1)
 * ①计算链表长度；
 * ②走`n-k`步，即指向倒数第k个节点。
 */
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || head.next == null || k <= 0) {
            return head;
        }

        int n = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            n++;
        }

        n = n - k;
        curr = head;
        while (n > 0) {
            curr = curr.next;
            n--;
        }
        return curr;
    }
}
