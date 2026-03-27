# 144. Binary Tree Preorder Traversal


# Given the root of a binary tree, return the preorder traversal of its nodes' values.

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def preorderTraversal(root):
    result = []

    def preorder(node):
        if not node:
            return

        result.append(node.val)
        preorder(node.left)
        preorder(node.right)

    preorder(root)
    return result


def main():
    # Example tree: [1,null,2,3]
    root = TreeNode(1)
    root.right = TreeNode(2)
    root.right.left = TreeNode(3)

    print(preorderTraversal(root))


if __name__ == "__main__":
    main()