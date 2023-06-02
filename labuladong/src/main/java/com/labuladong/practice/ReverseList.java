package com.labuladong.practice;

import java.util.Stack;

public class ReverseList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode tmp = head;
        while (tmp != null) {
            stack.push(tmp);
            tmp = tmp.next;
        }
        if (stack.isEmpty()) {
            return null;
        }
        ListNode result = stack.pop();
        while (!stack.isEmpty()) {
            result.next = stack.pop();
            result = result.next;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
        ListNode r = reverseList(node);
        while (r != null) {
            System.out.println(r.val);
            r = r.next;
        }
    }
}
