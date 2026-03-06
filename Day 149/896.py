# 896. Monotonic Array

# An array is monotonic if it is either monotone increasing or monotone decreasing.

# An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j]. An array nums is monotone decreasing if for all i <= j, nums[i] >= nums[j].

# Given an integer array nums, return true if the given array is monotonic, or false otherwise.

from typing import List

class Solution:
    def isMonotonic(self, nums: List[int]) -> bool:
        inc = True
        dec = True

        for i in range(len(nums) - 1):
            if nums[i] < nums[i + 1]:
                dec = False
            if nums[i] > nums[i + 1]:
                inc = False

        return inc or dec


# ---- Test block ----
if __name__ == "__main__":
    sol = Solution()
    nums = [1, 2, 2, 3]
    print(sol.isMonotonic(nums))  # True