# 77. Combinations
# Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].

# You may return the answer in any order.

from typing import List

class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        res = []
        def bt(start, path):
            if len(path) == k:
                res.append(path[:])
                return
            for i in range(start, n+1):
                path.append(i)
                bt(i+1, path)
                path.pop()
        bt(1, [])
        return res

# Test harness for VS Code
if __name__ == "__main__":
    sol = Solution()
    n, k = 4, 2
    result = sol.combine(n, k)
    print(result)
    # Output: [[1, 2], [1, 3], [1, 4], [2, 3], [2, 4], [3, 4]]
