# 136. Single Number
# Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

# You must implement a solution with a linear runtime complexity and use only constant extra space.
from typing import List

class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        ones, twos = 0, 0
        for num in nums:
            ones = (ones ^ num) & ~twos
            twos = (twos ^ num) & ~ones
        return ones

if __name__ == "__main__":
    nums = [2, 2, 2, 5, 3, 3, 3]
    sol = Solution()
    print(sol.singleNumber(nums))  # Output: 5

