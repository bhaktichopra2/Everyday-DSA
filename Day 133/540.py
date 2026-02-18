# 540. Single Element in a Sorted Array

# You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

# Return the single element that appears only once.

# Your solution must run in O(log n) time and O(1) space.

from typing import List

class Solution:
    def singleNonDuplicate(self, nums: List[int]) -> int:
        n = len(nums)
        
        if n == 1:
            return nums[0]
        if nums[0] != nums[1]:
            return nums[0]
        if nums[n - 1] != nums[n - 2]:
            return nums[n - 1]
        
        low, high = 1, n - 2
        while low <= high:
            mid = low + (high - low) // 2
            
            if nums[mid] != nums[mid - 1] and nums[mid] != nums[mid + 1]:
                return nums[mid]
            
            if (mid % 2 == 0 and nums[mid] == nums[mid + 1]) or \
               (mid % 2 == 1 and nums[mid] == nums[mid - 1]):
                low = mid + 1
            else:
                high = mid - 1
        
        return -1
    
    def test(self):
        sol = Solution()
        tests = [
            [1,1,2,3,3,4,4,8,8],
            [3,3,7,7,10,11,11],
            [1,1,2],
            [1]
        ]
        for test in tests:
            print(f"Input: {test} -> Single: {sol.singleNonDuplicate(test)}")

if __name__ == "__main__":
    Solution().test()
