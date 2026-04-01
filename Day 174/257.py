def binaryTreePaths(root):
    result = []

    def dfs(node, path):
        if not node:
            return

        # build path
        if path == "":
            path = str(node.val)
        else:
            path += "->" + str(node.val)

        # leaf node
        if not node.left and not node.right:
            result.append(path)
            return

        dfs(node.left, path)
        dfs(node.right, path)

    dfs(root, "")
    return result