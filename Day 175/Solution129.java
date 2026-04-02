// 129. Sum Root to Leaf Numbers

// You are given the root of a binary tree containing digits from 0 to 9 only.

// Each root-to-leaf path in the tree represents a number.

// For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
// Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.

// A leaf node is a node with no children.

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Solution129 {

    public static int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private static int dfs(TreeNode node, int current) {
        if (node == null) return 0;

        // build number along the path
        current = current * 10 + node.val;

        // if leaf node, return completed number
        if (node.left == null && node.right == null) {
            return current;
        }

        // sum from left and right subtrees
        return dfs(node.left, current) + dfs(node.right, current);
    }

    public static void main(String[] args) {
        /*
                1
               / \
              2   3

        Paths:
        1->2 = 12
        1->3 = 13

        Sum = 25
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(sumNumbers(root));
    }
}