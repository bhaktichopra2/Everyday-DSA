# 116. Populating Next Right Pointers in Each Node

# You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

# struct Node {
#   int val;
#   Node *left;
#   Node *right;
#   Node *next;
# }
# Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

# Initially, all next pointers are set to NULL.

class Node:
    def __init__(self, val=0, left=None, right=None, next=None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next


def connect(root):
    if not root:
        return None

    pre = root

    while pre.left:
        cur = pre

        while cur:
            # connect left → right
            cur.left.next = cur.right

            # connect right → next node's left
            if cur.next:
                cur.right.next = cur.next.left

            cur = cur.next

        pre = pre.left  # go to next level

    return root


def main():
    root = Node(1)
    root.left = Node(2)
    root.right = Node(3)

    root.left.left = Node(4)
    root.left.right = Node(5)
    root.right.left = Node(6)
    root.right.right = Node(7)

    connect(root)

    print(root.left.next.val)  # 3


if __name__ == "__main__":
    main()