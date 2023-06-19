package com.labuladong.study.linklist;

/**
 * https://leetcode.cn/problems/partition-list/
 */
public class PartitionList {

    public static class ListNode {
        int val;

        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

    }

    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);

        // p1是小于x的头节点链表，p2是大于等于x的头节点链表
        ListNode p1 = dummy1, p2 = dummy2;

        // p节点模拟分割，初始化为头节点
        ListNode p = head;

        while (p != null) {
            // 当前节点的值大于等于x，p被p2链接，p2前进到当前p的位置
            if (p.val >= x) {
                p2.next = p;
                p2 = p2.next;
            } else {
                // 当前节点小于x，p被p1链接，p1前进到当前p的位置
                p1.next = p;
                p1 = p1.next;
            }
            // p前进，继续模拟
            p = p.next;
        }
        p2.next = null;

        p1.next = dummy2.next;

        return dummy1.next;
    }


}
