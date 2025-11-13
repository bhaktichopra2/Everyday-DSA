# 226. Invert Binary Tree

# Given the root of a binary tree, invert the tree, and return its root.
from typing import Optional

class TreeNode:
    def __init__(self, val: int = 0, left: 'Optional[TreeNode]' = None, right: 'Optional[TreeNode]' = None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if not root:
            return None
        temp = root.left
        root.left = root.right
        root.right = temp
        self.invertTree(root.left)
        self.invertTree(root.right)
        return root

# Helper function for VSCode to print level order
def print_level_order(root: Optional[TreeNode]):
    if not root:
        print([])
        return
    from collections import deque
    queue = deque([root])
    vals = []
    while queue:
        node = queue.popleft()
        vals.append(node.val)
        if node.left:
            queue.append(node.left)
        if node.right:
            queue.append(node.right)
    print(vals)

# VSCode test block
if __name__ == "__main__":
    # Construct:   1
    #             / \
    #            2   3
    root = TreeNode(1, TreeNode(2), TreeNode(3))
    solution = Solution()
    inverted = solution.invertTree(root)
    print_level_order(inverted)  # Expected output: [1, 3, 2]
