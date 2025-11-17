// 108. Convert Sorted Array to Binary Search Tree
// Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.
import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        int n = nums.length;
        int mid = n / 2;
        TreeNode root = new TreeNode(nums[mid]);
        // Each queue item: parent, left, right
        Queue<Object[]> queue = new LinkedList<>();
        queue.offer(new Object[]{root, 0, mid - 1});
        queue.offer(new Object[]{root, mid + 1, n - 1});

        while (!queue.isEmpty()) {
            Object[] tup = queue.poll();
            TreeNode parent = (TreeNode) tup[0];
            int left = (Integer) tup[1];
            int right = (Integer) tup[2];
            if (left <= right) {
                int m = (left + right) / 2;
                TreeNode child = new TreeNode(nums[m]);
                if (nums[m] < parent.val) {
                    parent.left = child;
                } else {
                    parent.right = child;
                }
                queue.offer(new Object[]{child, left, m - 1});
                queue.offer(new Object[]{child, m + 1, right});
            }
        }
        return root;
    }

    // Helper: Pre-order traversal print
    public void printPreOrder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    // Main block for VSCode test
    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        Solution solution = new Solution();
        TreeNode bst = solution.sortedArrayToBST(nums);
        solution.printPreOrder(bst); // Output sample: 0 -10 -3 5 9
        System.out.println();
    }
}
