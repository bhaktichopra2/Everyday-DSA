# 100. Same Tree
# Given the roots of two binary trees p and q, write a function to check if they are the same or not.

# Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
from typing import Optional

class TreeNode:
    def __init__(self, val: int = 0, left: 'Optional[TreeNode]' = None, right: 'Optional[TreeNode]' = None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        stack = [(p, q)]
        while stack:
            node1, node2 = stack.pop()
            if not node1 and not node2:
                continue
            if None in [node1, node2] or node1.val != node2.val:
                return False
            stack.append((node1.right, node2.right))
            stack.append((node1.left, node2.left))
        return True

# VSCode test block
if __name__ == "__main__":
    # Build two identical trees:
    #    1
    #   / \
    #  2   3
    tree1 = TreeNode(1, TreeNode(2), TreeNode(3))
    tree2 = TreeNode(1, TreeNode(2), TreeNode(3))
    solution = Solution()
    print(solution.isSameTree(tree1, tree2))  # Expected: True

    # Change tree2 for a non-identical case
    tree2 = TreeNode(1, TreeNode(2), TreeNode(4))
    print(solution.isSameTree(tree1, tree2))  # Expected: False
