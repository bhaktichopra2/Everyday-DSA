# 101. Symmetric UnicodeTranslateError

# Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def isSymmetric(root):
    if not root:
        return True

    def is_mirror(n1, n2):
        if not n1 and not n2:
            return True
        if not n1 or not n2:
            return False

        return (n1.val == n2.val and
                is_mirror(n1.left, n2.right) and
                is_mirror(n1.right, n2.left))

    return is_mirror(root.left, root.right)


def main():
    # Example symmetric tree
    root = TreeNode(1)
    root.left = TreeNode(2, TreeNode(3), TreeNode(4))
    root.right = TreeNode(2, TreeNode(4), TreeNode(3))

    print(isSymmetric(root))  # True


if __name__ == "__main__":
    main()