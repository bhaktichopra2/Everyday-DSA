# 18. 4Sum
# Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

# 0 <= a, b, c, d < n
# a, b, c, and d are distinct.
# nums[a] + nums[b] + nums[c] + nums[d] == target
# You may return the answer in any order.

from typing import List

class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        n = len(nums)
        nums.sort()
        ans = []
        
        for i in range(n - 3):
            if i > 0 and nums[i] == nums[i-1]:
                continue
            
            for j in range(i + 1, n - 2):
                if j > i + 1 and nums[j] == nums[j-1]:
                    continue
                
                l, r = j + 1, n - 1
                
                while l < r:
                    total = nums[i] + nums[j] + nums[l] + nums[r]
                    
                    if total == target:
                        ans.append([nums[i], nums[j], nums[l], nums[r]])
                        while l < r and nums[l] == nums[l + 1]:
                            l += 1
                        while l < r and nums[r] == nums[r - 1]:
                            r -= 1
                        l += 1
                        r -= 1
                    elif total < target:
                        l += 1
                    else:
                        r -= 1
        
        return ans

if __name__ == "__main__":
    sol = Solution()
    print(sol.fourSum([2,2,2,2], 8))           # [[2,2,2,2]]
    print(sol.fourSum([1,0,-1,0,-2,2], 0))     # [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
