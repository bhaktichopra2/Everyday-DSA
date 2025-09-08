'''
845. Longest Mountain in Array
You may recall that an array arr is a mountain array if and only if:

arr.length >= 3
There exists some index i (0-indexed) with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
Given an integer array arr, return the length of the longest subarray, which is a mountain. Return 0 if there is no mountain subarray.
'''
from typing import List

class Solution:
    def longestMountain(self, arr: List[int]) -> int:
        ret = 0
        n = len(arr)
        for i in range(1, n-1):
            if arr[i-1] < arr[i] > arr[i+1]:
                l = i
                r = i
                while l > 0 and arr[l] > arr[l-1]:
                    l -= 1
                while r < n-1 and arr[r] > arr[r+1]:
                    r += 1
                ret = max(ret, r-l+1)
        return ret

# Example usage
if __name__ == "__main__":
    sol = Solution()
    arr = [2,1,4,7,3,2,5]
    print(sol.longestMountain(arr))  # Output: 5
