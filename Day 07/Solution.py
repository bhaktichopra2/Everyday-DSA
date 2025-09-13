# 136. Single Number
# Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

# You must implement a solution with a linear runtime complexity and use only constant extra space.

from typing import List

class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        res = 0
        for num in nums:
            res ^= num  
        return res

# Example usage
if __name__ == "__main__":
    sol = Solution()
    print(sol.singleNumber([4, 1, 2, 1, 2]))  # Output: 4

