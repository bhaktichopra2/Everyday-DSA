# 493. Reverse Pairs (#Attempted)
# Given an integer array nums, return the number of reverse pairs in the array.

# A reverse pair is a pair (i, j) where:

# 0 <= i < j < nums.length and
# nums[i] > 2 * nums[j].

#THIS SOLUTION DOESNT WORK FOR LONG NUMBERS
class Solution:
    def reversePairs(self, nums):
        count = 0
        n = len(nums)
        for i in range(n):
            for j in range(i + 1, n):
                if nums[i] > 2 * nums[j]:
                    count += 1
        return count

if __name__ == "__main__":
    sol = Solution()
    print(sol.reversePairs([1,3,2,3,1]))  # 2
    print(sol.reversePairs([2,4,3]))      # 1
