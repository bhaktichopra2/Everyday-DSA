# 46. Permutations
# Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

from typing import List

class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        def backtrack(start: int):
            if start == len(nums):
                res.append(nums[:])
                return
            for i in range(start, len(nums)):
                nums[start], nums[i] = nums[i], nums[start]
                backtrack(start + 1)
                nums[start], nums[i] = nums[i], nums[start]  # backtrack
        res = []
        backtrack(0)
        return res

if __name__ == "__main__":
    sol = Solution()
    nums = [1, 2, 3]
    result = sol.permute(nums)
    for perm in result:
        print(perm)
