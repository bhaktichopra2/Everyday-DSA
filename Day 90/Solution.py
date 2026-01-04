# 287. Find the Duplicate Number
# Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

# There is only one repeated number in nums, return this repeated number.

# You must solve the problem without modifying the array nums and using only constant extra space.
from typing import List

class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        slow = nums[0]
        fast = nums[0]

        while True:
            slow = nums[slow]
            fast = nums[nums[fast]]
            if slow == fast:
                break
        
        fast = nums[0]
        while slow != fast:
            slow = nums[slow]
            fast = nums[fast]
        
        return slow

if __name__ == "__main__":
    sol = Solution()
    
    # Test case: [1,3,4,2,2]
    nums = [1, 3, 4, 2, 2]
    print(f"Input:  {nums}")
    result = sol.findDuplicate(nums)
    print(f"Duplicate: {result}")
    
    # Test case: [3,1,3,4,2]  
    nums2 = [3, 1, 3, 4, 2]
    print(f"Input:  {nums2}")
    result2 = sol.findDuplicate(nums2)
    print(f"Duplicate: {result2}")
