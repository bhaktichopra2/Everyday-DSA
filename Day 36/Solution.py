# 104. Maximum Depth of Binary Tree
# Given the root of a binary tree, return its maximum depth.

# A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

from typing import Optional
from collections import deque

class TreeNode:
    def __init__(self, val: int = 0, left: 'Optional[TreeNode]' = None, right: 'Optional[TreeNode]' = None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        queue = deque([(root, 1)])
        level = 1
        while queue:
            node, curr_level = queue.popleft()
            level = max(level, curr_level)
            if node.left:
                queue.append((node.left, curr_level + 1))
            if node.right:
                queue.append((node.right, curr_level + 1))
        return level

# Test block for VSCode
if __name__ == "__main__":
    # Build the same tree as above
    root = TreeNode(1, TreeNode(2), TreeNode(3, TreeNode(4), TreeNode(5)))
    solution = Solution()
    print(solution.maxDepth(root))  # Expected: 3
