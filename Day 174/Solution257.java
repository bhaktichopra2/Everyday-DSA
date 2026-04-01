// 257. Binary Tree Paths

// Given the root of a binary tree, return all root-to-leaf paths in any order.

// A leaf is a node with no children.

import java.util.*;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Solution257 {

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();

        if (root == null) return result;

        dfs(root, "", result);
        return result;
    }

    private static void dfs(TreeNode node, String path, List<String> result) {
        if (node == null) return;

        // build current path
        if (path.isEmpty()) {
            path = Integer.toString(node.val);
        } else {
            path += "->" + node.val;
        }

        // leaf node
        if (node.left == null && node.right == null) {
            result.add(path);
            return;
        }

        dfs(node.left, path, result);
        dfs(node.right, path, result);
    }

    public static void main(String[] args) {
        /*
                1
               / \
              2   3
               \
                5

        Paths:
        1->2->5
        1->3
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        List<String> paths = binaryTreePaths(root);

        for (String s : paths) {
            System.out.println(s);
        }
    }
}