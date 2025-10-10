# 3232. Find if Digit Game Can Be Won
# You are given an array of positive integers nums.

# Alice and Bob are playing a game. In the game, Alice can choose either all single-digit numbers or all double-digit numbers from nums, and the rest of the numbers are given to Bob. Alice wins if the sum of her numbers is strictly greater than the sum of Bob's numbers.

# Return true if Alice can win this game, otherwise, return false.
from typing import List

class Solution:
    def canAliceWin(self, nums: List[int]) -> bool:
        single_sum = 0
        double_sum = 0
        for n in nums:
            if n < 10:
                single_sum += n
            else:
                double_sum += n
        return single_sum != double_sum

# Testing block for VSCode
if __name__ == "__main__":
    solution = Solution()
    test_nums = [5, 12, 3, 15, 8]
    print(solution.canAliceWin(test_nums))  # Expected: True
