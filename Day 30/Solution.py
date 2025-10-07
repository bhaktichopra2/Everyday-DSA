# 1550. Three Consecutive Odds
# Given an integer array arr, return true if there are three consecutive odd numbers in the array. Otherwise, return false.
from typing import List

class Solution:
    def threeConsecutiveOdds(self, arr: List[int]) -> bool:
        num = 0
        for i in range(len(arr)):
            if arr[i] % 2 != 0:
                num += 1
                if num == 3:
                    return True
            else:
                num = 0
        return False

# Test the function
if __name__ == "__main__":
    solution = Solution()
    test_arr = [2, 6, 4, 1, 3, 5]
    print(solution.threeConsecutiveOdds(test_arr))  # Expected: True
