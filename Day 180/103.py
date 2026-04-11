# 103. Binary Tree Zigzag Level Order Traversal

# Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

from collections import deque

# Class to represent a binary tree node
class TreeNode:
    def __init__(self, x):
        self.val = x          # Value of the node
        self.left = None      # Pointer to left child
        self.right = None     # Pointer to right child

class Solution:
    # Function to perform zigzag (spiral) level order traversal
    def zigzagLevelOrder(self, root):
        # List to store the final zigzag traversal result
        result = []

        # If tree is empty, return empty list
        if not root:
            return result

        # Queue for BFS traversal
        q = deque([root])

        # Boolean flag to control traversal direction
        leftToRight = True

        # Loop until all levels are processed
        while q:
            # Get the number of nodes at the current level
            size = len(q)

            # Temporary list to store current level's values
            level = [0] * size

            # Process each node in the current level
            for i in range(size):
                # Get the front node from queue
                node = q.popleft()

                # Determine index where this value should be stored
                index = i if leftToRight else size - 1 - i
                level[index] = node.val

                # Add left child to queue if it exists
                if node.left:
                    q.append(node.left)
                # Add right child to queue if it exists
                if node.right:
                    q.append(node.right)

            # Flip direction for the next level
            leftToRight = not leftToRight

            # Add current level to result
            result.append(level)

        # Return zigzag traversal result
        return result

# Driver code
if __name__ == "__main__":
    # Create binary tree:
    #        1
    #      /   \
    #     2     3
    #    / \     \
    #   4   5     6
    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left.left = TreeNode(4)
    root.left.right = TreeNode(5)
    root.right.right = TreeNode(6)

    # Create solution object
    sol = Solution()

    # Get zigzag traversal
    ans = sol.zigzagLevelOrder(root)

    # Print result
    print(ans)
