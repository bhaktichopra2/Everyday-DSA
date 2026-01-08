# 229. Majority Element II
# Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
from typing import List
from collections import defaultdict

class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        n = len(nums)
        result = []
        mpp = defaultdict(int)
        mini = n // 3 + 1

        for num in nums:
            mpp[num] += 1
            if mpp[num] == mini:
                result.append(num)
            if len(result) == 2:
                break
        return result

if __name__ == "__main__":
    sol = Solution()
    print(sol.majorityElement([3,2,3]))                    # [3]
    print(sol.majorityElement([3,1,2,3,2]))                # [3, 2]
    print(sol.majorityElement([1,1,1,2,3,4]))              # [1]
