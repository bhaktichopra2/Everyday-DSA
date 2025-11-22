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
        negative_count = 0
        for num in nums:
            if num == 0:
                return 0
            if num < 0:
                negative_count += 1
        return 1 if negative_count % 2 == 0 else -1
