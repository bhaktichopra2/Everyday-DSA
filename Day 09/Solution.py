# 70. Climbing Stairs
# You are climbing a staircase. It takes n steps to reach the top.

# Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

class Solution:
    def climbStairs(self, n: int) -> int:
        if n <= 2:
            return n
        dp = [0] * (n + 1)
        dp[1] = 1
        dp[2] = 2
        for i in range(3, n + 1):
            dp[i] = dp[i - 1] + dp[i - 2]
        return dp[n]

# Example usage
if __name__ == "__main__":
    sol = Solution()
    print(sol.climbStairs(3))  # Output: 3
    print(sol.climbStairs(5))  # Output: 8
