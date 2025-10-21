# 112. Path Sum
# Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.

# A leaf is a node with no children.
from typing import Optional
class TreeNode:
    def __init__(self, val: int = 0, left: 'Optional[TreeNode]' = None, right: 'Optional[TreeNode]' = None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def hasPathSum(self, root: Optional[TreeNode], targetSum: int) -> bool:
        if not root:
            return False
        stack = [(root, root.val)]
        while stack:
            curr, val = stack.pop()
            if not curr.left and not curr.right and val == targetSum:
                return True
            if curr.right:
                stack.append((curr.right, val + curr.right.val))
            if curr.left:
                stack.append((curr.left, val + curr.left.val))
        return False

# VSCode test block
if __name__ == "__main__":
    # Build the same test tree as Java
    root = TreeNode(5,
            TreeNode(4, TreeNode(11, TreeNode(7), TreeNode(2))),
            TreeNode(8, TreeNode(13), TreeNode(4, None, TreeNode(1)))
        )
    solution = Solution()
    print(solution.hasPathSum(root, 22)) # Expected: True
    print(solution.hasPathSum(root, 26)) # Expected: True
    print(solution.hasPathSum(root, 5))  # Expected: False
