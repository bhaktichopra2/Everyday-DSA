# 450. Delete Node in a BST
# Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

# Basically, the deletion can be divided into two stages:

# Search for a node to remove.
# If the node is found, delete the node.
from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def deleteNode(self, root: Optional[TreeNode], key: int) -> Optional[TreeNode]:
        if not root:
            return None
        if key < root.val:
            root.left = self.deleteNode(root.left, key)
        elif key > root.val:
            root.right = self.deleteNode(root.right, key)
        else:
            # Node with only one child or no child
            if not root.left:
                return root.right
            elif not root.right:
                return root.left
            else:
                # Node with two children: get the inorder successor (min on right)
                min_larger_node = self.getMin(root.right)
                root.val = min_larger_node.val
                root.right = self.deleteNode(root.right, min_larger_node.val)
        return root

    def getMin(self, node):
        while node.left:
            node = node.left
        return node

# Test block for VSCode
if __name__ == "__main__":
    # Sample BST
    #       5
    #      / \
    #     3   6
    #    / \   \
    #   2   4   7
    root = TreeNode(5, TreeNode(3, TreeNode(2), TreeNode(4)), TreeNode(6, None, TreeNode(7)))
    s = Solution()
    new_root = s.deleteNode(root, 3)
    # Inorder traversal to check deletion
    def inorder(node):
        if not node: return
        inorder(node.left)
        print(node.val, end=' ')
        inorder(node.right)
    inorder(new_root)  # Expected: 2 4 5 6 7
    print()
