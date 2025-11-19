// 235. Lowest Common Ancestor of a Binary Search Tree
// Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.

// According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) { val = x; }
    TreeNode(int x, TreeNode left, TreeNode right) {
        val = x;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int small = Math.min(p.val, q.val);
        int large = Math.max(p.val, q.val);
        while (root != null) {
            if (root.val > large) {
                root = root.left;
            } else if (root.val < small) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }

    // VSCode test block
    public static void main(String[] args) {
        // Build tree (see Python comment block for structure)
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4, new TreeNode(3), new TreeNode(5));
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        TreeNode p = root.left; // 2
        TreeNode q = root.left.right; // 4

        Solution solution = new Solution();
        TreeNode lca = solution.lowestCommonAncestor(root, p, q);
        System.out.println(lca.val); // Expected: 2
    }
}
