# 235. Lowest Common Ancestor of a Binary Search Tree
# Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.

# According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
from typing import Optional

class TreeNode:
    def __init__(self, x: int):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        small = min(p.val, q.val)
        large = max(p.val, q.val)
        while root:
            if root.val > large:
                root = root.left
            elif root.val < small:
                root = root.right
            else:
                return root
        return None

# VSCode test block
if __name__ == "__main__":
    """
    Tree:
        6
       / \
      2   8
     / \ / \
    0  4 7  9
      / \
     3   5
    """
    # Build the tree
    root = TreeNode(6)
    root.left = TreeNode(2)
    root.right = TreeNode(8)
    root.left.left = TreeNode(0)
    root.left.right = TreeNode(4)
    root.right.left = TreeNode(7)
    root.right.right = TreeNode(9)
    root.left.right.left = TreeNode(3)
    root.left.right.right = TreeNode(5)

    p = root.left        # 2
    q = root.left.right  # 4
    solution = Solution()
    lca = solution.lowestCommonAncestor(root, p, q)
    print(lca.val)  # Expected: 2
