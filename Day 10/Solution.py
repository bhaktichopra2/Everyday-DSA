# 53. Maximum Subarray
# Given an integer array nums, find the subarray with the largest sum, and return its sum.
from typing import List

class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        if not nums:
            return 0  # or raise exception
        dp = [0] * len(nums)
        dp[0] = nums[0]
        for i in range(1, len(nums)):
            dp[i] = max(nums[i], dp[i-1] + nums[i])
        return max(dp)

# Example usage:
if __name__ == "__main__":
    sol = Solution()
    print(sol.maxSubArray([-2,1,-3,4,-1,2,1,-5,4]))  # Output: 6
    print(sol.maxSubArray([1]))  # Output: 1
    print(sol.maxSubArray([5,4,-1,7,8]))  # Output: 23
