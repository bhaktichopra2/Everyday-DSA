# 513. Find Bottom Left Tree Value

# Given the root of a binary tree, return the leftmost value in the last row of the tree.

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def __init__(self):
        self.maxDepth = -1
        self.answer = 0

    def findBottomLeftValue(self, root):
        self.dfs(root, 0)
        return self.answer

    def dfs(self, node, depth):
        if not node:
            return

        # first node visited at this depth
        if depth > self.maxDepth:
            self.maxDepth = depth
            self.answer = node.val

        self.dfs(node.left, depth + 1)
        self.dfs(node.right, depth + 1)


def main():
    """
            1
           / \
          2   3
         /   / \
        4   5   6
           /
          7

    Bottom left value = 7
    """

    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)

    root.left.left = TreeNode(4)
    root.right.left = TreeNode(5)
    root.right.right = TreeNode(6)

    root.right.left.left = TreeNode(7)

    sol = Solution()
    print(sol.findBottomLeftValue(root))


if __name__ == "__main__":
    main()