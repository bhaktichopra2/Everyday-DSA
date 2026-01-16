# 560. Subarray Sum Equals K
# Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

# A subarray is a contiguous non-empty sequence of elements within an array.

from typing import List

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        running = 0
        total = 0
        
        sum_frequency = {0: 1}
        
        for i in range(len(nums)):
            running += nums[i]
            target_sum = running - k
            
            if target_sum in sum_frequency:
                total += sum_frequency[target_sum]
            
            sum_frequency[running] = sum_frequency.get(running, 0) + 1
        
        return total

if __name__ == "__main__":
    sol = Solution()
    print(sol.subarraySum([1,1,1], 2))              # 2
    print(sol.subarraySum([1,2,3], 3))              # 2
    print(sol.subarraySum([1,-1,1,1,-2,1,2,-1], 2)) # 8
