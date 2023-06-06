package com.labuladong.study;

public class ConnectTreeNext {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode next;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right, TreeNode next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }
    }

    public static TreeNode connect(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode cur = root;
        while (cur != null) {
            TreeNode temp = new TreeNode(0);
            // 每一层的前置节点
            TreeNode pre = temp;
            while (cur != null) {
                if (cur.left != null) {
                    pre.next = cur.left;
                    pre = pre.next;
                }
                if (cur.right != null) {
                    pre.next = cur.right;
                    pre = pre.next;
                }
                cur = cur.next;
            }
            cur = temp.next;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(4, null, null, null);
        TreeNode node5 = new TreeNode(5, null, null, null);
        TreeNode node7 = new TreeNode(7, null, null, null);
        TreeNode node2 = new TreeNode(2, node4, node5, null);
        TreeNode node3 = new TreeNode(3, null, node7, null);
        TreeNode root = new TreeNode(1, node2, node3, null);

        TreeNode conRoot = connect(root);
        while (conRoot != null) {
            System.out.println(conRoot.val);
            conRoot = conRoot.next;
        }
    }
}
