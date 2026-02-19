# 33. Search in Rotated Sorted Array 

# There is an integer array nums sorted in ascending order (with distinct values).

# Prior to being passed to your function, nums is possibly left rotated at an unknown index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be left rotated by 3 indices and become [4,5,6,7,0,1,2].

# Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

# You must write an algorithm with O(log n) runtime complexity.

from typing import List

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low, high = 0, len(nums) - 1
        
        while low <= high:
            mid = low + (high - low) // 2
            
            if nums[mid] == target:
                return mid
            
            # Left half sorted
            if nums[low] <= nums[mid]:
                if nums[low] <= target < nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
            # Right half sorted  
            else:
                if nums[mid] < target <= nums[high]:
                    low = mid + 1
                else:
                    high = mid - 1
        
        return -1

# VSCode Test ✅
def test():
    sol = Solution()
    tests = [
        ([4,5,6,7,0,1,2], 3),  # -1
        ([1], 0),              # -1
        ([4,5,6,7,0,1,2], 0),  # 4
        ([1,3], 3),            # 1
        ([5,1,3], 3)           # 2
    ]
    for nums, target in tests:
        result = sol.search(nums, target)
        print(f"nums={nums}, target={target} -> index={result}")

if __name__ == "__main__":
    test()
