# 701. Insert into a Binary Search Tree
# You are given the root node of a binary search tree (BST) and a value to insert into the tree. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.

# Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.
from typing import Optional

class TreeNode:
    def __init__(self, val: int = 0, left: 'Optional[TreeNode]' = None, right: 'Optional[TreeNode]' = None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def insertIntoBST(self, root: Optional[TreeNode], val: int) -> Optional[TreeNode]:
        new_node = TreeNode(val)
        if not root:
            return new_node
        current = root
        while True:
            if val < current.val:
                if current.left:
                    current = current.left
                else:
                    current.left = new_node
                    break
            else:
                if current.right:
                    current = current.right
                else:
                    current.right = new_node
                    break
        return root

# Helper for in-order traversal (to verify the result)
def print_in_order(root):
    if not root:
        return
    print_in_order(root.left)
    print(root.val, end=" ")
    print_in_order(root.right)

# VSCode test block
if __name__ == "__main__":
    # BST:    4
    #        / \
    #       2   7
    #      / \
    #     1   3
    root = TreeNode(4,
        TreeNode(2, TreeNode(1), TreeNode(3)),
        TreeNode(7)
    )
    solution = Solution()
    root = solution.insertIntoBST(root, 5)
    print_in_order(root)  # Expected in-order: 1 2 3 4 5 7
    print()
