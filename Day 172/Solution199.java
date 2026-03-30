// 199. Binary Tree Right Side View

// Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Solution199 {

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightView(root, result, 0);
        return result;
    }

    private static void rightView(TreeNode root, List<Integer> result, int level) {
        if (root == null) return;

        // first node seen at this level = rightmost node
        if (level == result.size()) {
            result.add(root.val);
        }

        rightView(root.right, result, level + 1);
        rightView(root.left, result, level + 1);
    }

    public static void main(String[] args) {
        /*
                1
               / \
              2   3
               \   \
                5   4

           Right side view = [1, 3, 4]
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        System.out.println(rightSideView(root));
    }
}