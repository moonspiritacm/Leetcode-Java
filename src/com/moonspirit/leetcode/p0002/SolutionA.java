package com.moonspirit.leetcode.p0002;

/**
 * 模拟加法。O(n) O(n)
 * 新建链表存储结果，每次循环在链表尾部添加一个新节点。
 * 使用头结点（又称伪元结点），可以减少了链表添加/删除时边界情况的判断。
 */
class SolutionA {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode dummyRoot = new ListNode();
        ListNode iter = dummyRoot;
        int add = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                add += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                add += l2.val;
                l2 = l2.next;
            }
            iter.next = new ListNode(add % 10);
            iter = iter.next;
            add /= 10;
        }
        if (add != 0) {
            iter.next = new ListNode(add);
        }
        return dummyRoot.next;
    }
}
