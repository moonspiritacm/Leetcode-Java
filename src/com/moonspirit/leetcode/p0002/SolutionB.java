package com.moonspirit.leetcode.p0002;

/**
 * 原地运算。O(n) O(1)
 * 挑选较长链表作为基础，修改其各个节点的值，实现原地加法运算。
 * 处理最后进位时需要添加新结点，注意边界条件的判断。
 */
class SolutionB {
    private int getSize(ListNode node) {
        int num = 0;
        while (node != null) {
            num++;
            node = node.next;
        }
        return num;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (getSize(l2) > getSize(l1)) {
            ListNode t = l1;
            l1 = l2;
            l2 = t;
        }

        ListNode iter = l1;
        int add = 0;
        while (true) {
            if (l2 != null) {
                add += l2.val;
                l2 = l2.next;
            }
            add += iter.val;
            iter.val = add % 10;
            add /= 10;
            if (iter.next == null) {
                break;
            }
            iter = iter.next;
        }
        if (add != 0) {
            iter.next = new ListNode(add);
        }
        return l1;
    }
}
