# 35. Search Insert Position
# Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

# You must write an algorithm with O(log n) runtime complexity.
from typing import List

class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        left, right = 0, len(nums) - 1
        
        while left <= right:
            mid = left + (right - left) // 2
            if nums[mid] == target:
                return mid
            elif nums[mid] < target:
                left = mid + 1
            else:
                right = mid - 1
        
        return left  # left is insertion point

# VSCode test cases
if __name__ == "__main__":
    s = Solution()
    print(s.searchInsert([1,3,5,6], 5))  # 2
    print(s.searchInsert([1,3,5,6], 2))  # 1
    print(s.searchInsert([1,3,5,6], 7))  # 4
    print(s.searchInsert([1,3,5,6], 0))  # 0
