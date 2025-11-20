// 530. Minimum Absolute Difference in BST
// Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.
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
    public int getMinimumDifference(TreeNode root) {
        int minDiff = Integer.MAX_VALUE;
        int preVal = Integer.MIN_VALUE;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        boolean first = true; // to skip diff for the very first node

        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                if (first) {
                    preVal = node.val;
                    first = false;
                } else {
                    minDiff = Math.min(minDiff, node.val - preVal);
                    preVal = node.val;
                }
                node = node.right;
            }
        }
        return minDiff;
    }

    // Simple test for VSCode
    public static void main(String[] args) {
        // BST:      4
        //         /   \
        //        2     6
        //       / \
        //      1   3
        TreeNode root = new TreeNode(4,
            new TreeNode(2, new TreeNode(1), new TreeNode(3)),
            new TreeNode(6)
        );
        Solution s = new Solution();
        System.out.println(s.getMinimumDifference(root)); // Expected: 1
    }
}
