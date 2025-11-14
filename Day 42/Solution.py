# 236. Lowest Common Ancestor of a Binary Tree
# Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

# According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
from typing import Optional

class TreeNode:
    def __init__(self, x: int):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root is None or root == p or root == q:
            return root
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)
        if left is not None and right is not None:
            return root
        return left if left is not None else right

# VSCode test block
if __name__ == "__main__":
    # Build tree:
    #      3
    #     / \
    #    5   1
    #   / \
    #  6   2
    root = TreeNode(3)
    node5 = TreeNode(5)
    node1 = TreeNode(1)
    node6 = TreeNode(6)
    node2 = TreeNode(2)
    root.left = node5; root.right = node1
    node5.left = node6; node5.right = node2

    solution = Solution()
    lca = solution.lowestCommonAncestor(root, node5, node1)
    print(lca.val)  # Expected: 3
    lca2 = solution.lowestCommonAncestor(root, node5, node6)
    print(lca2.val)  # Expected: 5
