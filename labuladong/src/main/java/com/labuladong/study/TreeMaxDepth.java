package com.labuladong.study;

public class TreeMaxDepth {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 动态规划思路，分解为求左右子树的最大深度
     *
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMaxDepth = maxDepth(root.left);
        int rightMaxDepth = maxDepth(root.right);
        return 1 + Math.max(leftMaxDepth, rightMaxDepth);
    }

    /**
     * 回溯算法
     */
    static int depth = 0;
    static int res = 0;

    public static int maxDepth2(TreeNode root) {
        traverse(root);
        return res;
    }

    // 遍历二叉树
    static void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        // 前序遍历位置
        depth++;
        // 遍历的过程中记录最大深度
        res = Math.max(res, depth);
        traverse(root.left);
        traverse(root.right);
        // 后序遍历位置
        depth--;
    }


    public static void main(String[] args) {
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode15 = new TreeNode(15);
        TreeNode treeNode7 = new TreeNode(7);

        TreeNode treeNode20 = new TreeNode(20, treeNode15, treeNode7);
        TreeNode root = new TreeNode(3, treeNode9, treeNode20);
        // 动态规划
        int depth = maxDepth(root);
        System.out.println(depth);
        // 回溯算法
        int depth2 = maxDepth2(root);
        System.out.println(depth2);
    }

}
