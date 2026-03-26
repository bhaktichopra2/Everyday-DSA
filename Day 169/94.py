# 94. Binary Tree Inorder Traversal

# Given the root of a binary tree, return the inorder traversal of its nodes' values.

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def inorderTraversal(root):
    result = []

    def inorder(node):
        if not node:
            return

        inorder(node.left)
        result.append(node.val)
        inorder(node.right)

    inorder(root)
    return result


def main():
    # Example tree: [1,null,2,3]
    root = TreeNode(1)
    root.right = TreeNode(2)
    root.right.left = TreeNode(3)

    print(inorderTraversal(root))


if __name__ == "__main__":
    main()