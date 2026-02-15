# Rat in a Maze
# Problem Statement: Given a grid of dimensions n x n. A rat is placed at coordinates (0, 0) and wants to reach at coordinates (n-1, n-1). Find all possible paths that rat can take to travel from (0, 0) to (n-1, n-1). The directions in which rat can move are 'U' (up) , 'D' (down) , 'L' (left) , 'R' (right).
# The value 0 in grid denotes that the cell is blocked and rat cannot use that cell for travelling, whereas value 1 represents that rat can travel through the cell. If the cell (0, 0) has 0 value, then mouse cannot move to any other cell.

class Solution:

    def isSafe(self, x, y, n, maze, visited):
        return (0 <= x < n and 0 <= y < n and 
                maze[x][y] == 1 and visited[x][y] == 0)

    # Function to solve maze using backtracking
    def solve(self, x, y, n, maze, visited, path, res):

        if x == n - 1 and y == n - 1:
            res.append(path)
            return

        visited[x][y] = 1

        if self.isSafe(x + 1, y, n, maze, visited):
            self.solve(x + 1, y, n, maze, visited, path + "D", res)

        if self.isSafe(x, y - 1, n, maze, visited):
            self.solve(x, y - 1, n, maze, visited, path + "L", res)
        
        if self.isSafe(x, y + 1, n, maze, visited):
            self.solve(x, y + 1, n, maze, visited, path + "R", res)
        
        if self.isSafe(x - 1, y, n, maze, visited):
            self.solve(x - 1, y, n, maze, visited, path + "U", res)

        visited[x][y] = 0

    # Main function to find all paths
    def findPath(self, maze, n):
        res = []
        visited = [[0] * n for _ in range(n)]
        if maze[0][0] == 1:
            self.solve(0, 0, n, maze, visited, "", res)
        return res


maze = [
    [1, 0, 0, 0],
    [1, 1, 0, 1],
    [1, 1, 0, 0],
    [0, 1, 1, 1]
]
n = len(maze)
obj = Solution()
paths = obj.findPath(maze, n)
print(" ".join(paths))
