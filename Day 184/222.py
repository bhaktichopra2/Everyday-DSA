# 222. Count Complete Tree Nodes

# Given the root of a complete binary tree, return the number of the nodes in the tree.

# According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

# Design an algorithm that runs in less than O(n) time complexity.

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def countNodes(self, root):
        if not root:
            return 0

        left_height = self.getLeftHeight(root)
        right_height = self.getRightHeight(root)

        # If heights are same, subtree is perfect
        if left_height == right_height:
            return (1 << left_height) - 1

        return 1 + self.countNodes(root.left) + self.countNodes(root.right)

    def getLeftHeight(self, node):
        height = 0
        while node:
            height += 1
            node = node.left
        return height

    def getRightHeight(self, node):
        height = 0
        while node:
            height += 1
            node = node.right
        return height


def main():
    """
            1
           
          2   3
         
        4  5 6

    Total nodes = 6
    """

    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)

    root.left.left = TreeNode(4)
    root.left.right = TreeNode(5)
    root.right.left = TreeNode(6)

    sol = Solution()
    print(sol.countNodes(root))


if __name__ == "__main__":
    main()