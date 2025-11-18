# 653. Two Sum IV - Input is a BST
# Given the root of a binary search tree and an integer k, return true if there exist two elements in the BST such that their sum is equal to k, or false otherwise.
from typing import Optional
from collections import deque

class TreeNode:
    def __init__(self, val: int = 0, left: 'Optional[TreeNode]' = None, right: 'Optional[TreeNode]' = None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def findTarget(self, root: Optional[TreeNode], k: int) -> bool:
        q = deque([root])
        numSet = set()
        while q:
            node = q.popleft()
            if (k - node.val) in numSet:
                return True
            numSet.add(node.val)
            if node.left:
                q.append(node.left)
            if node.right:
                q.append(node.right)
        return False

# VSCode test block
if __name__ == "__main__":
    # BST:      5
    #         /   \
    #        3     6
    #       / \     \
    #      2   4     7
    root = TreeNode(5, 
            TreeNode(3, TreeNode(2), TreeNode(4)), 
            TreeNode(6, None, TreeNode(7))
    )
    solution = Solution()
    print(solution.findTarget(root, 9))   # Expected: True
    print(solution.findTarget(root, 28))  # Expected: False
