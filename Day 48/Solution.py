# 530. Minimum Absolute Difference in BST
# Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.
from typing import Optional

class TreeNode:
    def __init__(self, val: int = 0, left: 'Optional[TreeNode]' = None, right: 'Optional[TreeNode]' = None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def getMinimumDifference(self, root: Optional[TreeNode]) -> int:
        minDiff = float('inf')
        preVal = float('-inf')

        stack = []
        node = root
        while node or stack:
            if node:
                stack.append(node)
                node = node.left
            else:
                node = stack.pop()
                minDiff = min(minDiff, node.val - preVal)
                preVal = node.val
                node = node.right
        return minDiff

# Simple test for VSCode
if __name__ == "__main__":
    # BST:      4
    #         /   \
    #        2     6
    #       / \
    #      1   3
    root = TreeNode(4,
            TreeNode(2, TreeNode(1), TreeNode(3)),
            TreeNode(6)
    )
    s = Solution()
    print(s.getMinimumDifference(root))  # Expected: 1
