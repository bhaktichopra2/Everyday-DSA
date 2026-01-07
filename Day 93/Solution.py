# 169. Majority Element
# Given an array nums of size n, return the majority element.

# The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
class Solution:
    def majorityElement(self, nums):
        n = len(nums)
        counts = {}
        
        for num in nums:
            counts[num] = counts.get(num, 0) + 1
        
        for num, frequency in counts.items():
            if frequency > n // 2:
                return num
        
        return -1

if __name__ == "__main__":
    sol = Solution()
    print(sol.majorityElement([3,2,3]))           # 3
    print(sol.majorityElement([2,2,1,1,1,2,2]))   # 2
