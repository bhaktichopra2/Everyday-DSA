# 105. Construct Binary Tree from Preorder and Inorder Traversal

# Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def buildTree(preorder, inorder):
    if not preorder or not inorder:
        return None

    # map for fast lookup
    inorder_map = {val: i for i, val in enumerate(inorder)}

    def helper(preL, preR, inL, inR):
        if preL > preR:
            return None

        root_val = preorder[preL]
        root = TreeNode(root_val)

        index = inorder_map[root_val]
        left_size = index - inL

        root.left = helper(preL + 1, preL + left_size, inL, index - 1)
        root.right = helper(preL + left_size + 1, preR, index + 1, inR)

        return root

    return helper(0, len(preorder) - 1, 0, len(inorder) - 1)


# Demo
def main():
    preorder = [3, 9, 20, 15, 7]
    inorder = [9, 3, 15, 20, 7]

    root = buildTree(preorder, inorder)
    print("Root:", root.val)


if __name__ == "__main__":
    main()