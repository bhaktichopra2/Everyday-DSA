// 1008. Construct Binary Search Tree from Preorder Traversal

// Given an array of integers preorder, which represents the preorder traversal of a BST (i.e., binary search tree), construct the tree and return its root.

// It is guaranteed that there is always possible to find a binary search tree with the given requirements for the given test cases.

// A binary search tree is a binary tree where for every node, any descendant of Node.left has a value strictly less than Node.val, and any descendant of Node.right has a value strictly greater than Node.val.

// A preorder traversal of a binary tree displays the value of the node first, then traverses Node.left, then traverses Node.right.

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Solution1008 {

    public static TreeNode bstFromPreorder(int[] preorder) {
        int n = preorder.length;

        Stack<TreeNode> st = new Stack<>();

        TreeNode root = new TreeNode(preorder[0]);
        st.push(root);   // 🔥 FIX

        for (int i = 1; i < n; i++) {
            TreeNode temp = null;

            while (!st.isEmpty() && preorder[i] > st.peek().val) {
                temp = st.pop();
            }

            if (temp != null) {
                temp.right = new TreeNode(preorder[i]);
                st.push(temp.right);
            } else {
                st.peek().left = new TreeNode(preorder[i]);
                st.push(st.peek().left);
            }
        }

        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {8, 5, 1, 7, 10, 12};

        TreeNode root = bstFromPreorder(preorder);
        System.out.println(root.val); // 8
    }
}