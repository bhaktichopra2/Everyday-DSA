# 128. Longest Consecutive Sequence
# Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

# You must write an algorithm that runs in O(n) time.

from typing import List

class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 0:
            return 0 

        longest = 1 
        st = set()

        # Add all numbers to set
        for i in range(n):
            st.add(nums[i])

        # Find longest sequence starting from beginnings
        for it in st:
            if it - 1 not in st:
                cnt = 1 
                x = it 

                while x + 1 in st:
                    x = x + 1 
                    cnt = cnt + 1 
                longest = max(longest, cnt)
        return longest

if __name__ == "__main__":
    sol = Solution()
    print(sol.longestConsecutive([100,4,200,1,3,2]))      # 4
    print(sol.longestConsecutive([0,3,7,2,5,8,4,6,0,1]))  # 9
    print(sol.longestConsecutive([1]))                     # 1
