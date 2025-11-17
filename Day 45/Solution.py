# 108. Convert Sorted Array to Binary Search Tree
# Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.
from typing import List, Optional
from collections import deque

class TreeNode:
    def __init__(self, val: int = 0, left: 'Optional[TreeNode]' = None, right: 'Optional[TreeNode]' = None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def sortedArrayToBST(self, nums: List[int]) -> Optional[TreeNode]:
        if not nums:
            return None
        n = len(nums)
        mid = n // 2
        root = TreeNode(nums[mid])
        q = deque()
        q.append((root, 0, mid - 1))
        q.append((root, mid + 1, n - 1))
        while q:
            parent, left, right = q.popleft()
            if left <= right:
                m = (left + right) // 2
                child = TreeNode(nums[m])
                if nums[m] < parent.val:
                    parent.left = child
                else:
                    parent.right = child
                q.append((child, left, m - 1))
                q.append((child, m + 1, right))
        return root

# Helper: Pre-order print to check output
def print_preorder(root):
    if not root:
        return
    print(root.val, end=" ")
    print_preorder(root.left)
    print_preorder(root.right)

# VSCode test block
if __name__ == "__main__":
    nums = [-10, -3, 0, 5, 9]
    solution = Solution()
    bst = solution.sortedArrayToBST(nums)
    print_preorder(bst) # Output sample: 0 -10 -3 5 9
    print()
