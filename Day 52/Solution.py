# 230. Kth Smallest Element in a BST
# Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        stack = []
        while root or stack:
            while root:
                stack.append(root)
                root = root.left
            root = stack.pop()
            k -= 1
            if k == 0:
                return root.val
            root = root.right

# Test block for VSCode
if __name__ == "__main__":
    # Example tree:
    #   3
    #  / \
    # 1   4
    #  \
    #   2
    root = TreeNode(3, TreeNode(1, None, TreeNode(2)), TreeNode(4))
    s = Solution()
    print(s.kthSmallest(root, 1))  # Expected: 1
    print(s.kthSmallest(root, 2))  # Expected: 2
    print(s.kthSmallest(root, 3))  # Expected: 3
