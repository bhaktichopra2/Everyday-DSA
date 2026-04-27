// 101. Symmetric UnicodeTranslateError

// Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution101 {

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    private static boolean isMirror(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) return true;
        if (n1 == null || n2 == null) return false;

        return n1.val == n2.val &&
               isMirror(n1.left, n2.right) &&
               isMirror(n1.right, n2.left);
    }

    public static void main(String[] args) {
        // Example symmetric tree
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(2, new TreeNode(4), new TreeNode(3))
        );

        System.out.println(isSymmetric(root)); // true
    }
}