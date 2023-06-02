package com.labuladong.practice;

public class LinkedListCopy {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    static class Solution {

        public static Node copyRandomList(Node head) {
            if (head == null) {
                return null;
            }
            Node nextNode = head;
            while (nextNode != null) {
                Node nodeNew = new Node(nextNode.val);
                nodeNew.next = nextNode.next;
                nextNode.next = nodeNew;
                nextNode = nodeNew.next;
            }

            Node randomNode = head;
            while (randomNode != null) {
                if (randomNode.random != null) {
                    randomNode.next.random = randomNode.random.next;
                }
                randomNode = randomNode.next.next;
            }

            Node cur = head.next;
            Node pre = head, res = head.next;

            while (cur.next != null) {
                pre.next = pre.next.next;
                cur.next = cur.next.next;
                pre = pre.next;
                cur = cur.next;
            }
            pre.next = null;
            return res;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        node1.random = node4;
        node4.random = node2;
        node2.random = node3;
        node3.random = null;

        System.out.println(node1);
        Node node = Solution.copyRandomList(node1);
        System.out.println(node);
    }
}
