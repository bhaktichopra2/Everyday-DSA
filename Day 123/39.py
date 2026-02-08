# 39. Combination Sum
# Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

# The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

# The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

from typing import List

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        ans = []
        ds = []
        self.findComb(0, target, candidates, ans, ds)
        return ans
    
    def findComb(self, ind: int, target: int, arr: List[int], ans: List[List[int]], ds: List[int]):
        if ind == len(arr):
            if target == 0:
                ans.append(list(ds))
            return
        
        # Pick current (UNLIMITED times - same index!)
        if arr[ind] <= target:
            ds.append(arr[ind])
            self.findComb(ind, target - arr[ind], arr, ans, ds)
            ds.pop()
        
        # Don't pick - next element
        self.findComb(ind + 1, target, arr, ans, ds)
    
    # VSCode Test
    def test(self):
        sol = Solution()
        candidates = [2, 3, 6, 7]
        target = 7
        print(sol.combinationSum(candidates, target))

if __name__ == "__main__":
    Solution().test()
