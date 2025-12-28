# 867. Transpose Matrix
# Given a 2D integer array matrix, return the transpose of matrix.

# The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices.
from typing import List

class Solution:
    def transpose(self, matrix: List[List[int]]) -> List[List[int]]:
        row = len(matrix)
        col = len(matrix[0])
        transpose = [[0] * row for _ in range(col)]
        
        for i in range(row):
            for j in range(col):
                transpose[j][i] = matrix[i][j]
        return transpose

if __name__ == "__main__":
    sol = Solution()
    
    # Test: 2x3 matrix
    matrix = [[1,2,3],[4,5,6]]
    result = sol.transpose(matrix)
    
    print("Original:", matrix)
    print("Transpose:", result)
    # Output: [[1,4],[2,5],[3,6]]
