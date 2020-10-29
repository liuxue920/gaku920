package com.fafamc.forfun.leetcode;

public class No129_20201029 {
    public int sumNumbers(TreeNode root) {
        return helper(root,0);
    }

    public int helper(TreeNode root, int i){
        if (root == null) return 0;
        int temp = i * 10 + root.val;
        if (root.left == null && root.right == null)
            return temp;
        return helper(root.left, temp) + helper(root.right, temp);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);

        root.left.left=new TreeNode(5);
        root.left.right=new TreeNode(1);

        root.left.right.left=new TreeNode(2);
        root.left.right.left=new TreeNode(3);

        root.right=new TreeNode(0);

        No129_20201029 solution = new No129_20201029();

        System.out.println(solution.sumNumbers(root));

        System.out.println(495+4912+4913+40);

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
