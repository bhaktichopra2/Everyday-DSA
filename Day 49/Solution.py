# 1382. Balance a Binary Search Tree
# Given the root of a binary search tree, return a balanced binary search tree with the same node values. If there is more than one answer, return any of them.

# A binary search tree is balanced if the depth of the two subtrees of every node never differs by more than 1.
from typing import Optional, List

class TreeNode:
    def __init__(self, val: int = 0, left: 'Optional[TreeNode]' = None, right: 'Optional[TreeNode]' = None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def balanceBST(self, root: TreeNode) -> TreeNode:
        vals: List[int] = []

        def inorder(node: Optional[TreeNode]):
            if not node:
                return
            inorder(node.left)
            vals.append(node.val)
            inorder(node.right)

        inorder(root)

        def build(l: int, r: int) -> Optional[TreeNode]:
            if l > r:
                return None
            mid = (l + r) // 2
            node = TreeNode(vals[mid])
            node.left = build(l, mid - 1)
            node.right = build(mid + 1, r)
            return node

        return build(0, len(vals) - 1)

# Simple VSCode test
if __name__ == "__main__":
    # Skewed BST: 1 -> 2 -> 3 -> 4
    root = TreeNode(1, None, TreeNode(2, None, TreeNode(3, None, TreeNode(4))))
    s = Solution()
    new_root = s.balanceBST(root)
    # You can add a traversal print here to verify shape
