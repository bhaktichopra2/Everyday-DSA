# 1822. Sign of the Product of an Array
# Implement a function signFunc(x) that returns:

# 1 if x is positive.
# -1 if x is negative.
# 0 if x is equal to 0.
# You are given an integer array nums. Let product be the product of all values in the array nums.

# Return signFunc(product).
from typing import List

class Solution:
    def arraySign(self, nums: List[int]) -> int:
        sign = 1
        for i in range(len(nums)):
            if nums[i] == 0:
                return 0
            elif nums[i] < 0:
                sign = -sign
        return sign

# Testing block for VSCode
if __name__ == "__main__":
    solution = Solution()
    test_nums = [-1, -2, -3, 4, 3, 2, 1]
    print(solution.arraySign(test_nums))  # Expected: -1
