// 543. Diameter of Binary Tree
// Given the root of a binary tree, return the length of the diameter of the tree.

// The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

// The length of a path between two nodes is represented by the number of edges between them.
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
    private int diameter;

    public int diameterOfBinaryTree(TreeNode root) {
        this.diameter = 0;
        depth(root);
        return this.diameter;
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        this.diameter = Math.max(this.diameter, leftDepth + rightDepth);
        return 1 + Math.max(leftDepth, rightDepth);
    }

    // Main method for VSCode testing
    public static void main(String[] args) {
        // Construct tree:
        //     1
        //    / \
        //   2   3
        //  / \
        // 4   5
        TreeNode root = new TreeNode(1,
            new TreeNode(2, new TreeNode(4), new TreeNode(5)),
            new TreeNode(3)
        );
        Solution solution = new Solution();
        System.out.println(solution.diameterOfBinaryTree(root)); // Expected: 3 (length from 4→2→1→3 or 5→2→1→3)
    }
}

