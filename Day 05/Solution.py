# 1200. Minimum Absolute Difference
# Given an array of distinct integers arr, find all pairs of elements with the minimum absolute difference of any two elements.

# Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows

# a, b are from arr
# a < b
# b - a equals to the minimum absolute difference of any two elements in arr

from typing import List

class Solution:
    def minimumAbsDifference(self, arr: List[int]) -> List[List[int]]:
        arr.sort()
        minDiff = float('inf')
        for i in range(1, len(arr)):
            minDiff = min(minDiff, arr[i] - arr[i-1])

        res = []
        for i in range(1, len(arr)):
            if minDiff == arr[i] - arr[i-1]:
                res.append([arr[i-1], arr[i]])

        return res

# Example usage
if __name__ == "__main__":
    sol = Solution()
    print(sol.minimumAbsDifference([4,2,1,3]))  # Output: [[1, 2], [2, 3], [3, 4]]
    print(sol.minimumAbsDifference([1,3,6,10,15]))  # Output: [[1, 3]]
    print(sol.minimumAbsDifference([3,8,-10,23,19,-4,-14,27]))  # Output: [[-14, -10], [19, 23], [23, 27]]
