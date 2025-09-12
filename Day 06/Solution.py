# 209. Minimum Size Subarray Sum

# Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

from typing import List

class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        l = 0
        sum_ = 0
        res = float("inf")
        for r in range(len(nums)):
            sum_ += nums[r]
            while sum_ >= target:
                res = min(res, r - l + 1)
                sum_ -= nums[l]
                l += 1
        return 0 if res == float("inf") else res

# Example usage
if __name__ == "__main__":
    sol = Solution()
    print(sol.minSubArrayLen(7, [2,3,1,2,4,3]))  # Output: 2
    print(sol.minSubArrayLen(4, [1,4,4]))        # Output: 1
    print(sol.minSubArrayLen(11, [1,1,1,1,1,1,1,1]))  # Output: 0
