# 594. Longest Harmonious Subsequence

# We define a harmonious array as an array where the difference between its maximum value and its minimum value is exactly 1.

# Given an integer array nums, return the length of its longest harmonious subsequence among all its possible subsequences.

class Solution:
    def findLHS(self, nums):
        from collections import Counter
        
        freq = Counter(nums)
        max_len = 0
        
        for num in freq:
            if num + 1 in freq:
                max_len = max(max_len, freq[num] + freq[num+1])
        
        return max_len