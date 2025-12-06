# 88. Merge Sorted Array
# Solved
# Easy
# Topics
# premium lock icon
# Companies
# Hint
# You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

# Merge nums1 and nums2 into a single array sorted in non-decreasing order.

# The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
from typing import List

class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        i = m - 1
        j = n - 1
        k = m + n - 1
        
        while j >= 0:
            if i >= 0 and nums1[i] > nums2[j]:
                nums1[k] = nums1[i]
                i -= 1
            else:
                nums1[k] = nums2[j]
                j -= 1
            k -= 1

# Test harness for VS Code
def test_merge():
    # Test case: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
    # Expected: [1,2,2,3,5,6]
    nums1 = [1, 2, 3, 0, 0, 0]
    m = 3
    nums2 = [2, 5, 6]
    n = 3
    
    sol = Solution()
    sol.merge(nums1, m, nums2, n)
    print(f"Merged result: {nums1}")  # [1, 2, 2, 3, 5, 6]

if __name__ == "__main__":
    test_merge()
