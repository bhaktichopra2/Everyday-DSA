// 116. Populating Next Right Pointers in Each Node

// You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

// struct Node {
//   int val;
//   Node *left;
//   Node *right;
//   Node *next;
// }
// Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

// Initially, all next pointers are set to NULL.

class Node {
    int val;
    Node left, right, next;

    Node(int val) {
        this.val = val;
    }
}

public class Solution116 {

    public static Node connect(Node root) {
        if (root == null) return null;

        Node pre = root;

        while (pre.left != null) {
            Node cur = pre;

            while (cur != null) {
                // connect left → right
                cur.left.next = cur.right;

                // connect right → next node's left
                if (cur.next != null) {
                    cur.right.next = cur.next.left;
                }

                cur = cur.next;
            }

            pre = pre.left; // move to next level
        }

        return root;
    }

    public static void main(String[] args) {
        /*
                1
              /   \
             2     3
            / \   / \
           4  5  6  7
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        connect(root);

        System.out.println(root.left.next.val); // 3
    }
}