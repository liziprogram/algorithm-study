package com.labuladong.study.linklist;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKList {

    public static class ListNode {
        int val;

        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

    }


    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        // 小根堆
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, Comparator.comparingInt(a -> a.val));

        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            p.next = node;
            if (node.next != null) {
                pq.add(node.next);
            }
            p = p.next;
        }
        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = null;

        ListNode listNode4 = new ListNode(1);
        ListNode listNode5 = new ListNode(3);
        ListNode listNode6 = new ListNode(4);
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = null;

        ListNode listNode7 = new ListNode(2);
        ListNode listNode8 = new ListNode(6);
        listNode7.next = listNode8;
        listNode8.next = null;

        ListNode[] listNodes = new ListNode[]{listNode1, listNode4, listNode7};
        // 递归测试
        ListNode r = mergeKLists(listNodes);
        while (r != null) {
            System.out.print(r.val + "->");
            r = r.next;
        }
    }
}
