# 40. Combination Sum II
# Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

# Each number in candidates may only be used once in the combination.

# Note: The solution set must not contain duplicate combinations.

from typing import List

class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        candidates.sort()
        ans = []
        ds = []
        self.findComb(0, target, candidates, ans, ds)
        return ans
    
    def findComb(self, ind: int, target: int, arr: List[int], ans: List[List[int]], ds: List[int]):
        if target == 0:
            ans.append(list(ds))
            return
        
        for i in range(ind, len(arr)):
            # Skip duplicates at same level
            if i > ind and arr[i] == arr[i - 1]:
                continue
            
            # Pruning
            if arr[i] > target:
                break
            
            ds.append(arr[i])
            self.findComb(i + 1, target - arr[i], arr, ans, ds)
            ds.pop()
    
    # VSCode Test
    def test(self):
        sol = Solution()
        candidates = [10, 1, 2, 7, 6, 1, 5]
        target = 8
        print(sol.combinationSum2(candidates, target))

if __name__ == "__main__":
    Solution().test()
