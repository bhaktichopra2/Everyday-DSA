# 1008. Construct Binary Search Tree from Preorder Traversal

# Given an array of integers preorder, which represents the preorder traversal of a BST (i.e., binary search tree), construct the tree and return its root.

# It is guaranteed that there is always possible to find a binary search tree with the given requirements for the given test cases.

# A binary search tree is a binary tree where for every node, any descendant of Node.left has a value strictly less than Node.val, and any descendant of Node.right has a value strictly greater than Node.val.

# A preorder traversal of a binary tree displays the value of the node first, then traverses Node.left, then traverses Node.right.

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def bstFromPreorder(self, preorder):
        self.index = 0

        def build(min_val, max_val):
            # base condition
            if (self.index == len(preorder) or
                preorder[self.index] < min_val or
                preorder[self.index] > max_val):
                return None

            root_val = preorder[self.index]
            self.index += 1

            root = TreeNode(root_val)

            root.left = build(min_val, root_val)
            root.right = build(root_val, max_val)

            return root

        return build(float('-inf'), float('inf'))


def main():
    preorder = [8, 5, 1, 7, 10, 12]

    sol = Solution()
    root = sol.bstFromPreorder(preorder)

    print(root.val)  # 8


if __name__ == "__main__":
    main()