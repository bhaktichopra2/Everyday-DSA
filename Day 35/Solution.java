// 111. Minimum Depth of Binary Tree
// Given a binary tree, find its minimum depth.

// The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

// Note: A leaf is a node with no children.
import java.util.*;

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
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); 
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                if (currentNode.left == null && currentNode.right == null)
                    return depth;
                if (currentNode.left != null) queue.offer(currentNode.left);
                if (currentNode.right != null) queue.offer(currentNode.right);
            }
            depth++;
        }
        return depth;
    }

    // Main method for test in VSCode
    public static void main(String[] args) {
        // Build tree:      1
        //                 / \
        //                2   3
        //                   / \
        //                  4   5
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)));
        Solution solution = new Solution();
        System.out.println(solution.minDepth(root)); // Expected: 2
    }
}
