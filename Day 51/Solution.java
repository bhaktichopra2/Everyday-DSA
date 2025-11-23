// 450. Delete Node in a BST
// Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

// Basically, the deletion can be divided into two stages:

// Search for a node to remove.
// If the node is found, delete the node.
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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                // Node with two children: find inorder successor (min in right)
                TreeNode minNode = getMin(root.right);
                root.val = minNode.val;
                root.right = deleteNode(root.right, minNode.val);
            }
        }
        return root;
    }

    private TreeNode getMin(TreeNode node) {
        while (node.left != null) node = node.left;
        return node;
    }

    // Test block for VSCode
    public static void main(String[] args) {
        //       5
        //      / \
        //     3   6
        //    / \   \
        //   2   4   7
        TreeNode root = new TreeNode(5,
            new TreeNode(3, new TreeNode(2), new TreeNode(4)),
            new TreeNode(6, null, new TreeNode(7))
        );
        Solution s = new Solution();
        TreeNode newRoot = s.deleteNode(root, 3);
        // Inorder traversal to check deletion
        inorder(newRoot); // Expected: 2 4 5 6 7
        System.out.println();
    }
    static void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.val + " ");
        inorder(node.right);
    }
}
