# Nth Root of a Number using Binary Search

# Problem Statement: Given two numbers N and M, find the Nth root of M. The nth root of a number M is defined as a number X when raised to the power N equals M. If the 'nth root is not an integer, return -1.

class Solution:
    # Function to find N-th root of M using binary search
    def nthRoot(self, n, m):
        low, high = 1, m

        while low <= high:
            mid = (low + high) // 2

            ans = 1
            for _ in range(n):
                ans *= mid
                if ans > m:
                    break

            if ans == m:
                return mid
            if ans < m:
                low = mid + 1
            else:
                high = mid - 1

        return -1

# Driver code
obj = Solution()
result = obj.nthRoot(3, 27)
print(result)
