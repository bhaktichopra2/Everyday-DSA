# 485. Max Consecutive Ones
# Given a binary array nums, return the maximum number of consecutive 1's in the array.
from typing import List

class Solution:
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
        curr = 0
        best = 0

        for num in nums:
            if num == 1:
                curr += 1
                if curr > best:
                    best = curr
            else:
                curr = 0
        return best

if __name__ == "__main__":
    sol = Solution()
    nums = [1, 1, 0, 1, 1, 1]
    print(sol.findMaxConsecutiveOnes(nums))  # 3
