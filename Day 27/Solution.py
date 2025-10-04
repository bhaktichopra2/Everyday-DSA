# 496. Next Greater Element I
# The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.

# You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.

# For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.

# # Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.

from typing import List

class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        result = [0] * len(nums1)
        for i in range(len(nums1)):
            result[i] = -1
            for j in range(len(nums2)):
                if nums1[i] == nums2[j]:
                    for k in range(j + 1, len(nums2)):
                        if nums2[k] > nums2[j]:
                            result[i] = nums2[k]
                            break
                    break
        return result

if __name__ == "__main__":
    sol = Solution()
    nums1 = [4, 1, 2]
    nums2 = [1, 3, 4, 2]
    result = sol.nextGreaterElement(nums1, nums2)
    print(result)  # Output: [-1, 3, -1]
