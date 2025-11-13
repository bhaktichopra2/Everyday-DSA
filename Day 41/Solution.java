// 226. Invert Binary Tree

// Given the root of a binary tree, invert the tree, and return its root.
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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    // Helper to print tree level-order for VSCode visualization
    public void printLevelOrder(TreeNode root) {
        if (root == null) {
            System.out.println("[]");
            return;
        }
        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.offer(root);
        java.util.List<Integer> vals = new java.util.ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            vals.add(node.val);
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        System.out.println(vals);
    }

    // Main test block for VSCode
    public static void main(String[] args) {
        // Construct:   1
        //             / \
        //            2   3
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        Solution solution = new Solution();
        TreeNode inverted = solution.invertTree(root);
        solution.printLevelOrder(inverted); // Expected output: [1, 3, 2]
    }
}
