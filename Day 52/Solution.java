// 230. Kth Smallest Element in a BST
// Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            k--;
            if (k == 0) return root.val;
            root = root.right;
        }
        return -1; // Should never reach here if k is valid
    }

    // Test block for VSCode
    public static void main(String[] args) {
        // Example tree:
        //   3
        //  / \
        // 1   4
        //  \
        //   2
        TreeNode root = new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4));
        Solution s = new Solution();
        System.out.println(s.kthSmallest(root, 1)); // 1
        System.out.println(s.kthSmallest(root, 2)); // 2
        System.out.println(s.kthSmallest(root, 3)); // 3
    }
}
