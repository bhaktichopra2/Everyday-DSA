// 145. Binary Tree Postorder Traversal

// Given the root of a binary tree, return the postorder traversal of its nodes' values.

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Solution145 {

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    private static void postorder(TreeNode root, List<Integer> result) {
        if (root == null) return;

        postorder(root.left, result);
        postorder(root.right, result);
        result.add(root.val);
    }

    public static void main(String[] args) {
        // Example tree: [1,null,2,3]
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        System.out.println(postorderTraversal(root));
    }
}