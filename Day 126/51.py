# 51. N-Queens
# The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

# Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

# Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

class Solution:
    def isSafe(self, row, col, board, n):
        # Check left in same row
        for j in range(col):
            if board[row][j] == 'Q':
                return False
        
        # Check upper diagonal
        i, j = row, col
        while i >= 0 and j >= 0:
            if board[i][j] == 'Q':
                return False
            i -= 1
            j -= 1
        
        # Check lower diagonal
        i, j = row, col
        while i < n and j >= 0:
            if board[i][j] == 'Q':
                return False
            i += 1
            j -= 1
        
        return True
    
    def solve(self, col, board, ans, n):
        # Base case - all queens placed
        if col == n:
            ans.append([''.join(row) for row in board])
            return
        
        # Try each row in current column
        for row in range(n):
            if self.isSafe(row, col, board, n):
                # 🔥 PLACE QUEEN
                board[row][col] = 'Q'
                self.solve(col + 1, board, ans, n)
                # 🔥 BACKTRACK
                board[row][col] = '.'
    
    def solveNQueens(self, n):
        ans = []
        board = [['.' for _ in range(n)] for _ in range(n)]
        self.solve(0, board, ans, n)
        return ans

# VSCode Test
if __name__ == "__main__":
    sol = Solution()
    print(sol.solveNQueens(4))
