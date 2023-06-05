package com.labuladong.study;

import java.util.LinkedList;
import java.util.List;

public class PreOrder {

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }


    public List<Integer> preOrderNode(Node root) {
        traverse(root);
        return list;
    }

    static List<Integer> list = new LinkedList<>();

    static void traverse(Node root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (root.children == null) {
            return;
        }
        for (Node node : root.children) {
            traverse(node);
        }
    }
}
