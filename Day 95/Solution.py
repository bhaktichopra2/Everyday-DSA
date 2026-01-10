# 62. Unique Paths
# There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

# Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

# The test cases are generated so that the answer will be less than or equal to 2 * 109.

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [[-1 for j in range(n)] for i in range(m)]
        return self.func(m-1, n-1, dp)
    
    def func(self, i, j, dp):
        if i == 0 and j == 0:
            return 1
        if i < 0 or j < 0:
            return 0
        if dp[i][j] != -1:
            return dp[i][j]
        
        up = self.func(i-1, j, dp)
        left = self.func(i, j-1, dp)
        
        dp[i][j] = up + left
        return dp[i][j]

if __name__ == "__main__":
    sol = Solution()
    print(sol.uniquePaths(3, 7))  # 28
    print(sol.uniquePaths(3, 2))  # 3
