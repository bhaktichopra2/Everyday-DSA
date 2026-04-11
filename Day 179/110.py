# 110. Balanced Binary Tree

# Given a binary tree, determine if it is height-balanced

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def isBalanced(root):

    def dfsHeight(node):
        if not node:
            return 0

        leftHeight = dfsHeight(node.left)
        if leftHeight == -1:
            return -1

        rightHeight = dfsHeight(node.right)
        if rightHeight == -1:
            return -1

        # not balanced
        if abs(leftHeight - rightHeight) > 1:
            return -1

        return 1 + max(leftHeight, rightHeight)

    return dfsHeight(root) != -1


def main():
    """
            1
           / \
          2   3
         / \
        4   5

    Balanced -> True
    """

    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)

    root.left.left = TreeNode(4)
    root.left.right = TreeNode(5)

    print(isBalanced(root))


if __name__ == "__main__":
    main()