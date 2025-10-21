// 112. Path Sum
// Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.

// A leaf is a node with no children.
import java.util.Stack;

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
    // Helper class to store node and current path sum
    private static class NodeSumPair {
        TreeNode node;
        int sum;
        NodeSumPair(TreeNode node, int sum) {
            this.node = node;
            this.sum = sum;
        }
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        Stack<NodeSumPair> stack = new Stack<>();
        stack.push(new NodeSumPair(root, root.val));
        while (!stack.isEmpty()) {
            NodeSumPair pair = stack.pop();
            TreeNode curr = pair.node;
            int sum = pair.sum;
            if (curr.left == null && curr.right == null && sum == targetSum) {
                return true;
            }
            if (curr.right != null)
                stack.push(new NodeSumPair(curr.right, sum + curr.right.val));
            if (curr.left != null)
                stack.push(new NodeSumPair(curr.left, sum + curr.left.val));
        }
        return false;
    }

    // Main method for VSCode test
    public static void main(String[] args) {
        // Example tree:    5
        //                 / \
        //                4   8
        //               /   / \
        //              11  13  4
        //             /  \      \
        //            7    2      1
        TreeNode root = new TreeNode(5,
            new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
            new TreeNode(8, new TreeNode(13), new TreeNode(4, null, new TreeNode(1)))
        );
        Solution solution = new Solution();
        System.out.println(solution.hasPathSum(root, 22)); // Expected: true
        System.out.println(solution.hasPathSum(root, 26)); // Expected: true
        System.out.println(solution.hasPathSum(root, 5));  // Expected: false
    }
}
