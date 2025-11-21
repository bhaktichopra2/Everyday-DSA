// 1382. Balance a Binary Search Tree
// Given the root of a binary search tree, return a balanced binary search tree with the same node values. If there is more than one answer, return any of them.

// A binary search tree is balanced if the depth of the two subtrees of every node never differs by more than 1.
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
    private List<Integer> vals = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        return build(0, vals.size() - 1);
    }

    private void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        vals.add(node.val);
        inorder(node.right);
    }

    private TreeNode build(int l, int r) {
        if (l > r) return null;
        int mid = (l + r) / 2;
        TreeNode node = new TreeNode(vals.get(mid));
        node.left = build(l, mid - 1);
        node.right = build(mid + 1, r);
        return node;
    }

    // VSCode test
    public static void main(String[] args) {
        // Skewed: 1 -> 2 -> 3 -> 4
        TreeNode root = new TreeNode(1, null,
                new TreeNode(2, null,
                        new TreeNode(3, null,
                                new TreeNode(4))));
        Solution s = new Solution();
        TreeNode newRoot = s.balanceBST(root);
        // You can add a traversal print here to inspect the balanced tree
    }
}
