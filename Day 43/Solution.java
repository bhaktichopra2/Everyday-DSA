// 700. Search in a Binary Search Tree
// You are given the root of a binary search tree (BST) and an integer val.

// Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null) {
            if (root.val == val) return root;
            if (root.val < val) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return null;
    }

    // Helper method for demonstration
    public static void printTreeNode(TreeNode node) {
        if (node == null) {
            System.out.println("null");
        } else {
            System.out.println(node.val);
        }
    }

    // Main for VSCode testing
    public static void main(String[] args) {
        //       4
        //      / \
        //     2   7
        //    / \
        //   1   3
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7));
        Solution solution = new Solution();
        printTreeNode(solution.searchBST(root, 2)); // Expected: 2
        printTreeNode(solution.searchBST(root, 5)); // Expected: null
    }
}
