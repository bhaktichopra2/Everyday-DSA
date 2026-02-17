# Median of Row Wise Sorted Matrix

# Problem Statement:
# Given a row-wise sorted matrix of size M*N, where M is no. of rows and N is no. of columns, find the median in the given matrix.
# Note: M*N is odd.

import bisect

class Solution:
    # Function to count elements <= mid using bisect
    def countLessEqual(self, row, mid):
        return bisect.bisect_right(row, mid)

    # Function to find median
    def findMedian(self, matrix):
        rows = len(matrix)
        cols = len(matrix[0])

        low = min(row[0] for row in matrix)
        high = max(row[-1] for row in matrix)

        while low < high:
            mid = (low + high) // 2
            count = 0

            for row in matrix:
                count += self.countLessEqual(row, mid)

            if count < (rows * cols + 1) // 2:
                low = mid + 1
            else:
                high = mid

        return low

# Driver code
matrix = [
    [1, 3, 5],
    [2, 6, 9],
    [3, 6, 9]
]
obj = Solution()
print("Median:", obj.findMedian(matrix))
