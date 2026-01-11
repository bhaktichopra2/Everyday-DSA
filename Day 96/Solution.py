# 2965. Find Missing and Repeated Values
# You are given a 0-indexed 2D integer matrix grid of size n * n with values in the range [1, n2]. Each integer appears exactly once except a which appears twice and b which is missing. The task is to find the repeating and missing numbers a and b.

# Return a 0-indexed integer array ans of size 2 where ans[0] equals to a and ans[1] equals to b.

from typing import List

class Solution:
    def findMissingAndRepeatedValues(self, grid: List[List[int]]) -> List[int]:
        n = len(grid)
        total = n * n
        count = [0] * (total + 1)
        
        # Count frequency of each number (1 to n²)
        for row in grid:
            for num in row:
                count[num] += 1
        
        rep, mis = -1, -1
        # Find repeated (count=2) and missing (count=0)
        for i in range(1, total + 1):
            if count[i] == 2:
                rep = i
            elif count[i] == 0:
                mis = i
        
        return [rep, mis]

if __name__ == "__main__":
    sol = Solution()
    grid1 = [[1,3],[2,2]]
    print(sol.findMissingAndRepeatedValues(grid1))  # [2, 4]
    
    grid2 = [[1,1],[2,3]]
    print(sol.findMissingAndRepeatedValues(grid2))  # [1, 4]
