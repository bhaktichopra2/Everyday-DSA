// 513. Find Bottom Left Tree Value

// Given the root of a binary tree, return the leftmost value in the last row of the tree.

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Solution513 {

    int maxDepth = -1;
    int answer = 0;

    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return answer;
    }

    private void dfs(TreeNode node, int depth) {
        if (node == null) return;

        // first node visited at this depth
        if (depth > maxDepth) {
            maxDepth = depth;
            answer = node.val;
        }

        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }

    public static void main(String[] args) {
        /*
                1
               / \
              2   3
             /   / \
            4   5   6
               /
              7

           Bottom left value = 7
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        root.right.left.left = new TreeNode(7);

        Solution513 sol = new Solution513();
        System.out.println(sol.findBottomLeftValue(root));
    }
}