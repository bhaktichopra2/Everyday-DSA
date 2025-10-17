// 100. Same Tree
// Given the roots of two binary trees p and q, write a function to check if they are the same or not.

// // Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

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

import java.util.Stack;

public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[]{p, q});
        while (!stack.isEmpty()) {
            TreeNode[] nodes = stack.pop();
            TreeNode node1 = nodes[0], node2 = nodes[1];
            if (node1 == null && node2 == null) continue;
            if (node1 == null || node2 == null || node1.val != node2.val) return false;
            stack.push(new TreeNode[]{node1.right, node2.right});
            stack.push(new TreeNode[]{node1.left, node2.left});
        }
        return true;
    }

    // Main method for VSCode testing
    public static void main(String[] args) {
        // First pair: Same tree
        TreeNode p = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode q = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        // Second pair: Different trees
        TreeNode r = new TreeNode(1, new TreeNode(2), new TreeNode(4));
        Solution solution = new Solution();

        System.out.println(solution.isSameTree(p, q)); // Expected: true
        System.out.println(solution.isSameTree(p, r)); // Expected: false
    }
}
