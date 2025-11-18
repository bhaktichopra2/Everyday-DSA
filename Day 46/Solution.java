// 653. Two Sum IV - Input is a BST
// Given the root of a binary search tree and an integer k, return true if there exist two elements in the BST such that their sum is equal to k, or false otherwise.
import java.util.*;

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
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        Set<Integer> numSet = new HashSet<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (numSet.contains(k - node.val)) {
                return true;
            }
            numSet.add(node.val);
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        return false;
    }

    public static void main(String[] args) {
        // BST:      5
        //         /   \
        //        3     6
        //       / \     \
        //      2   4     7
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3, new TreeNode(2), new TreeNode(4));
        root.right = new TreeNode(6, null, new TreeNode(7));

        Solution solution = new Solution();
        System.out.println(solution.findTarget(root, 9));   // Expected: true (2 + 7)
        System.out.println(solution.findTarget(root, 28));  // Expected: false
    }
}
