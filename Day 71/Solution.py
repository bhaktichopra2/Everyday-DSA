# 283. Move Zeroes
# Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

# Note that you must do this in-place without making a copy of the array.
from typing import List

class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        index = 0
        # Move all non-zero elements forward
        for i in range(len(nums)):
            if nums[i] != 0:
                nums[index] = nums[i]
                index += 1
        # Fill the remaining positions with zero
        for i in range(index, len(nums)):
            nums[i] = 0

if __name__ == "__main__":
    nums = [0, 1, 0, 3, 12]
    sol = Solution()
    sol.moveZeroes(nums)
    print(nums)  # [1, 3, 12, 0, 0]
