package com.labuladong.study;

public class TreeHasPathSum {

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
     * 递归
     *
     * @param root
     * @return
     */
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }


    public static void main(String[] args) {
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode15 = new TreeNode(15);
        TreeNode treeNode7 = new TreeNode(7);

        TreeNode treeNode20 = new TreeNode(20, treeNode15, treeNode7);
        TreeNode root = new TreeNode(3, treeNode9, treeNode20);

        boolean hasPathSum = hasPathSum(root,30);
        System.out.println(hasPathSum);

    }
}
