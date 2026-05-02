# 106. Construct Binary Tree from Inorder and Postorder Traversal

# Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def buildTree(self, inorder, postorder):
        if len(inorder) != len(postorder):
            return None
        hm = {val: idx for idx, val in enumerate(inorder)}
        return self._build(inorder, 0, len(inorder) - 1,
                           postorder, 0, len(postorder) - 1, hm)

    def _build(self, inorder, is_, ie, postorder, ps, pe, hm):
        if ps > pe or is_ > ie:
            return None
        root_val = postorder[pe]
        root = TreeNode(root_val)
        inRoot = hm[root_val]
        numsLeft = inRoot - is_
        root.left = self._build(inorder, is_, inRoot - 1,
                                postorder, ps, ps + numsLeft - 1, hm)
        root.right = self._build(inorder, inRoot + 1, ie,
                                 postorder, ps + numsLeft, pe - 1, hm)
        return root

def printInorder(root):
    if not root:
        return
    printInorder(root.left)
    print(root.val, end=" ")
    printInorder(root.right)

if __name__ == "__main__":
    inorder = [40, 20, 50, 10, 60, 30]
    postorder = [40, 50, 20, 60, 30, 10]
    print("Inorder Vector:", inorder)
    print("Postorder Vector:", postorder)

    sol = Solution()
    root = sol.buildTree(inorder, postorder)
    print("Inorder of Unique Binary Tree Created:")
    printInorder(root)
    print()
