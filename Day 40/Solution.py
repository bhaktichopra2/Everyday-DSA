# 543. Diameter of Binary Tree
# Given the root of a binary tree, return the length of the diameter of the tree.

# The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

# The length of a path between two nodes is represented by the number of edges between them.
from typing import Optional

class TreeNode:
    def __init__(self, val: int = 0, left: 'Optional[TreeNode]' = None, right: 'Optional[TreeNode]' = None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        self.diameter = 0
        def depth(node: Optional[TreeNode]) -> int:
            if not node:
                return 0
            left_depth = depth(node.left)
            right_depth = depth(node.right)
            self.diameter = max(self.diameter, left_depth + right_depth)
            return 1 + max(left_depth, right_depth)
        depth(root)
        return self.diameter

# VSCode test block
if __name__ == "__main__":
    # Build tree as in Java:
    #     1
    #    / \
    #   2   3
    #  / \
    # 4   5
    root = TreeNode(1,
        TreeNode(2, TreeNode(4), TreeNode(5)),
        TreeNode(3)
    )
    solution = Solution()
    print(solution.diameterOfBinaryTree(root))  # Expected: 3
