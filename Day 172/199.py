# 199. Binary Tree Right Side View

# Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def rightSideView(root):
    result = []

    def rightView(node, level):
        if not node:
            return

        # first node at this level = rightmost node
        if level == len(result):
            result.append(node.val)

        rightView(node.right, level + 1)
        rightView(node.left, level + 1)

    rightView(root, 0)
    return result


def main():
    """
            1
           / \
          2   3
           \   \
            5   4

    Right side view = [1, 3, 4]
    """

    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)

    root.left.right = TreeNode(5)
    root.right.right = TreeNode(4)

    print(rightSideView(root))


if __name__ == "__main__":
    main()