# 145. Binary Tree Postorder Traversal

# Given the root of a binary tree, return the postorder traversal of its nodes' values.

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def postorderTraversal(root):
    result = []

    def postorder(node):
        if not node:
            return

        postorder(node.left)
        postorder(node.right)
        result.append(node.val)

    postorder(root)
    return result


def main():
    # Example tree: [1,null,2,3]
    root = TreeNode(1)
    root.right = TreeNode(2)
    root.right.left = TreeNode(3)

    print(postorderTraversal(root))


if __name__ == "__main__":
    main()