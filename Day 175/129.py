# 129. Sum Root to Leaf Numbers

# You are given the root of a binary tree containing digits from 0 to 9 only.

# Each root-to-leaf path in the tree represents a number.

# For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
# Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.

# A leaf node is a node with no children.

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def sumNumbers(root):

    def dfs(node, current):
        if not node:
            return 0

        # build current number
        current = current * 10 + node.val

        # leaf node
        if not node.left and not node.right:
            return current

        return dfs(node.left, current) + dfs(node.right, current)

    return dfs(root, 0)


def main():
    """
            1
           / \
          2   3

    Numbers:
    12 and 13

    Sum = 25
    """

    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)

    print(sumNumbers(root))


if __name__ == "__main__":
    main()