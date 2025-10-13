// 104. Maximum Depth of Binary Tree
// Given the root of a binary tree, return its maximum depth.

// A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
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
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode[]> queue = new LinkedList<>();
        queue.offer(new TreeNode[]{root, new TreeNode(1)});
        int level = 1;

        while (!queue.isEmpty()) {
            TreeNode[] pair = queue.poll();
            TreeNode node = pair[0];
            int currLevel = pair[1].val;
            level = Math.max(level, currLevel);
            if (node.left != null)
                queue.offer(new TreeNode[]{node.left, new TreeNode(currLevel + 1)});
            if (node.right != null)
                queue.offer(new TreeNode[]{node.right, new TreeNode(currLevel + 1)});
        }
        return level;
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
        System.out.println(solution.maxDepth(root)); // Expected: 3
    }
}
