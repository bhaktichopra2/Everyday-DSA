// 236. Lowest Common Ancestor of a Binary Tree
// Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

// According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) { this.val = x; }
}

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    // Helper to build and test in VSCode
    public static void main(String[] args) {
        // Tree:
        //      3
        //     / \
        //    5   1
        //   / \
        //  6   2
        TreeNode root = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        root.left = node5; root.right = node1;
        node5.left = node6; node5.right = node2;
        Solution solution = new Solution();
        TreeNode lca = solution.lowestCommonAncestor(root, node5, node1);
        System.out.println(lca.val); // Expected: 3
        TreeNode lca2 = solution.lowestCommonAncestor(root, node5, node6);
        System.out.println(lca2.val); // Expected: 5
    }
}
