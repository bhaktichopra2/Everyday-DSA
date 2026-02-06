# Subset Sum : Sum of all Subsets

# Problem Statement: Given an array print all the sum of the subset generated from it, in the increasing order.

class Solution:
    # Recursive helper function to find subset sums
    def findSums(self, index, currentSum, arr, sums):
        if index == len(arr):
            sums.append(currentSum)
            return
        # Include current element
        self.findSums(index + 1, currentSum + arr[index], arr, sums)
        # Exclude current element
        self.findSums(index + 1, currentSum, arr, sums)

    def subsetSums(self, arr):
        sums = []
        self.findSums(0, 0, arr, sums)
        sums.sort()
        return sums

# Driver code
if __name__ == "__main__":
    sol = Solution()
    arr = [5, 2, 1]
    result = sol.subsetSums(arr)
    print(*result)
