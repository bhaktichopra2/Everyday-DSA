# 700. Search in a Binary Search Tree
# You are given the root of a binary search tree (BST) and an integer val.

# Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.
from typing import Optional

class TreeNode:
    def __init__(self, val: int = 0, left: 'Optional[TreeNode]' = None, right: 'Optional[TreeNode]' = None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def searchBST(self, root: Optional[TreeNode], val: int) -> Optional[TreeNode]:
        while root:
            if root.val == val:
                return root
            if root.val < val:
                root = root.right
            else:
                root = root.left
        return None

# VSCode test block
if __name__ == "__main__":
    #      4
    #     / \
    #    2   7
    #   / \
    #  1   3
    root = TreeNode(4, TreeNode(2, TreeNode(1), TreeNode(3)), TreeNode(7))
    solution = Solution()
    found = solution.searchBST(root, 2)
    print(found.val if found else None)  # Expected: 2
    not_found = solution.searchBST(root, 5)
    print(not_found.val if not_found else None)  # Expected: None
