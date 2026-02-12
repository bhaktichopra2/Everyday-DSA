# 51. N-Queens
# The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

# Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

# Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

from typing import List

class Solution:
    def solve(self, col: int, board: List[List[str]], n: int,
              leftRow: List[int], upperDiagonal: List[int], lowerDiagonal: List[int],
              res: List[List[str]]):
        
        # Base case
        if col == n:
            res.append([''.join(row) for row in board])
            return
        
        # Try each row
        for row in range(n):
            if (leftRow[row] == 0 and 
                lowerDiagonal[row + col] == 0 and 
                upperDiagonal[n - 1 + col - row] == 0):
                
                # Place + mark
                board[row][col] = 'Q'
                leftRow[row] = 1
                lowerDiagonal[row + col] = 1
                upperDiagonal[n - 1 + col - row] = 1
                
                self.solve(col + 1, board, n, leftRow, upperDiagonal, lowerDiagonal, res)
                
                # Backtrack
                board[row][col] = '.'
                leftRow[row] = 0
                lowerDiagonal[row + col] = 0
                upperDiagonal[n - 1 + col - row] = 0
    
    def solveNQueens(self, n: int) -> List[List[str]]:
        res = []
        board = [['.' for _ in range(n)] for _ in range(n)]
        
        # O(N) tracking arrays
        leftRow = [0] * n
        lowerDiagonal = [0] * (2 * n - 1)
        upperDiagonal = [0] * (2 * n - 1)
        
        self.solve(0, board, n, leftRow, upperDiagonal, lowerDiagonal, res)
        return res

# VSCode Test
if __name__ == "__main__":
    sol = Solution()
    print("N=4 solutions:")
    result = sol.solveNQueens(4)
    for board in result:
        print(board)
