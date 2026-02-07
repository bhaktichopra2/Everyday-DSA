# 90. Subsets II
# Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

# The solution set must not contain duplicate subsets. Return the solution in any order.

from typing import List

class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        result = []
        path = []
        nums.sort()  # Critical!
        self.backtrack(0, nums, path, result)
        return result
    
    def backtrack(self, start: int, nums: List[int], path: List[int], result: List[List[int]]):
        result.append(path[:])  # Copy path
        
        for i in range(start, len(nums)):
            if i > start and nums[i] == nums[i - 1]:
                continue
            path.append(nums[i])
            self.backtrack(i + 1, nums, path, result)
            path.pop()
    
    # VSCode Test
    def test(self):
        sol = Solution()
        print("Test 1:", sol.subsetsWithDup([1, 2, 2]))
        print("Test 2:", sol.subsetsWithDup([4, 4, 4, 1, 4]))

if __name__ == "__main__":
    Solution().test()
