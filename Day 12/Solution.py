# 303. Range Sum Query - Immutable
# Given an integer array nums, handle multiple queries of the following type:

# Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
# Implement the NumArray class:

# NumArray(int[] nums) Initializes the object with the integer array nums.
# int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).

from typing import List

class NumArray:
    def __init__(self, nums: List[int]):
        self.acc_nums = [0]
        for num in nums:
            self.acc_nums.append(self.acc_nums[-1] + num)

    def sumRange(self, left: int, right: int) -> int:
        return self.acc_nums[right + 1] - self.acc_nums[left]

# Test harness for VS Code
if __name__ == "__main__":
    nums = [1, 2, 3, 4, 5]
    obj = NumArray(nums)
    print(obj.sumRange(1, 3)) # sum from index 1 to 3 => 2+3+4 = 9
    print(obj.sumRange(0, 4)) # sum from index 0 to 4 => 1+2+3+4+5 = 15
