// 987. Vertical Order Traversal of a Binary Tree


// Given the root of a binary tree, calculate the vertical order traversal of the binary tree.

// For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1) and (row + 1, col + 1) respectively. The root of the tree is at (0, 0).

// The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting from the leftmost column and ending on the rightmost column. There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.

// Return the vertical order traversal of the binary tree.


import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

class Pair {
    TreeNode node;
    int col, row;

    Pair(TreeNode node, int col, int row) {
        this.node = node;
        this.col = col;
        this.row = row;
    }
}

public class Solution987 {

    public static List<List<Integer>> verticalTraversal(TreeNode root) {

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0, 0));

        while (!queue.isEmpty()) {
            Pair p = queue.poll();

            TreeNode node = p.node;
            int col = p.col;
            int row = p.row;

            map.putIfAbsent(col, new TreeMap<>());
            map.get(col).putIfAbsent(row, new PriorityQueue<>());
            map.get(col).get(row).offer(node.val);

            if (node.left != null) {
                queue.offer(new Pair(node.left, col - 1, row + 1));
            }

            if (node.right != null) {
                queue.offer(new Pair(node.right, col + 1, row + 1));
            }
        }

        List<List<Integer>> result = new ArrayList<>();

        for (TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()) {
            List<Integer> column = new ArrayList<>();

            for (PriorityQueue<Integer> pq : rows.values()) {
                while (!pq.isEmpty()) {
                    column.add(pq.poll());
                }
            }

            result.add(column);
        }

        return result;
    }

    public static void main(String[] args) {
        /*
                 3
                / \
               9  20
                  / \
                 15  7

           Output: [[9],[3,15],[20],[7]]
        */

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(verticalTraversal(root));
    }
}