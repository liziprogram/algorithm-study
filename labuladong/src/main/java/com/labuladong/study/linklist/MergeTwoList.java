package com.labuladong.study.linklist;

public class MergeTwoList {

    public static class ListNode {
        int val;

        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

    }


    /**
     * 迭代版本
     *
     * @param list1
     * @param list2
     * @return
     */
    private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return list1;
        }
        if (list1 == null && list2 != null) {
            return list2;
        }
        if (list1 != null && list2 == null) {
            return list1;
        }
        ListNode pre = new ListNode(0);
        ListNode p = pre;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                p.next = list1;
                list1 = list1.next;
            } else {
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
        }

        if (list1 != null) {
            p.next = list1;
        }

        if (list2 != null) {
            p.next = list2;
        }

        return pre.next;
    }

    /**
     * 递归版本
     */
    private static ListNode mergeTwoListsByRecursion(ListNode p1, ListNode p2) {
        if (p1 == null) {
            return p2;
        }
        if (p2 == null) {
            return p1;
        }
        if (p1.val <= p2.val) {
            p1.next = mergeTwoListsByRecursion(p1.next, p2);
            return p1;
        } else {
            p2.next = mergeTwoListsByRecursion(p1, p2.next);
            return p2;
        }
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(8);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = null;

        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(9);
        listNode4.next = listNode5;
        listNode5.next = null;

//        // 迭代测试
//        ListNode res = mergeTwoLists(listNode1, listNode4);
//        while (res != null) {
//            System.out.print(res.val + "->");
//            res = res.next;
//        }

        // 递归测试
        ListNode r = mergeTwoListsByRecursion(listNode1, listNode4);
        while (r != null) {
            System.out.print(r.val + "->");
            r = r.next;
        }
    }
}
