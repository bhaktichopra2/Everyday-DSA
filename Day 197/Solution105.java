// 105. Construct Binary Tree from Preorder and Inorder Traversal

// Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Solution105 {

    static Map<Integer, Integer> inorderMap;

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return helper(preorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private static TreeNode helper(int[] preorder, int preL, int preR,
                                   int inL, int inR) {

        if (preL > preR) return null;

        int rootVal = preorder[preL];
        TreeNode root = new TreeNode(rootVal);

        int index = inorderMap.get(rootVal);
        int leftSize = index - inL;

        root.left = helper(preorder, preL + 1, preL + leftSize, inL, index - 1);
        root.right = helper(preorder, preL + leftSize + 1, preR, index + 1, inR);

        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode root = buildTree(preorder, inorder);
        System.out.println("Root: " + root.val);
    }
}