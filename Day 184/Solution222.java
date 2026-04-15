// 222. Count Complete Tree Nodes

// Given the root of a complete binary tree, return the number of the nodes in the tree.

// According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

// Design an algorithm that runs in less than O(n) time complexity.

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Solution222 {

    public static int countNodes(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = getLeftHeight(root);
        int rightHeight = getRightHeight(root);

        // perfect binary tree
        if (leftHeight == rightHeight) {
            return (1 << leftHeight) - 1;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private static int getLeftHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.left;
        }
        return height;
    }

    private static int getRightHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.right;
        }
        return height;
    }

    public static void main(String[] args) {
        /*
                1
               / \
              2   3
             / \  /
            4  5 6

            Total nodes = 6
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        System.out.println(countNodes(root));
    }
}