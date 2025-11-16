// 701. Insert into a Binary Search Tree
// You are given the root node of a binary search tree (BST) and a value to insert into the tree. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.

// Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.
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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode current = root;
        while (true) {
            if (val < current.val) {
                if (current.left != null) {
                    current = current.left;
                } else {
                    current.left = new TreeNode(val);
                    break;
                }
            } else {
                if (current.right != null) {
                    current = current.right;
                } else {
                    current.right = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }

    // Helper to print in-order traversal for verifying tree structure
    public void printInOrder(TreeNode root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }

    // Main test block for VSCode
    public static void main(String[] args) {
        // BST:    4
        //        / \
        //       2   7
        //      / \
        //     1   3
        TreeNode root = new TreeNode(4, 
            new TreeNode(2, new TreeNode(1), new TreeNode(3)),
            new TreeNode(7)
        );
        Solution solution = new Solution();
        root = solution.insertIntoBST(root, 5);
        solution.printInOrder(root); // Expected in-order: 1 2 3 4 5 7
        System.out.println();
    }
}