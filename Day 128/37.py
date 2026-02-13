# 37. Sudoku Solver
# Write a program to solve a Sudoku puzzle by filling the empty cells.

# A sudoku solution must satisfy all of the following rules:

# Each of the digits 1-9 must occur exactly once in each row.
# Each of the digits 1-9 must occur exactly once in each column.
# Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
# The '.' character indicates empty cells.

class Solution:
    def solveSudoku(self, board):
        self.solve(board)
    
    def solve(self, board):
        for i in range(9):
            for j in range(9):
                if board[i][j] == '.':
                    for c in '123456789':
                        if self.isValid(board, i, j, c):
                            board[i][j] = c
                            if self.solve(board):
                                return True
                            board[i][j] = '.'  # Backtrack
                    return False
        return True
    
    def isValid(self, board, row, col, c):
        # Check row
        for i in range(9):
            if board[row][i] == c:
                return False
        
        # Check column
        for i in range(9):
            if board[i][col] == c:
                return False
        
        # Check 3x3 box
        startRow, startCol = 3 * (row // 3), 3 * (col // 3)
        for i in range(3):
            for j in range(3):
                if board[startRow + i][startCol + j] == c:
                    return False
        return True

# VSCode Test
if __name__ == "__main__":
    sol = Solution()
    board = [
        ['5','3','.','.','7','.','.','.','.'],
        ['6','.','.','1','9','5','.','.','.'],
        ['.','9','8','.','.','.','.','6','.'],
        ['8','.','.','.','6','.','.','.','3'],
        ['4','.','.','8','.','3','.','.','1'],
        ['7','.','.','.','2','.','.','.','6'],
        ['.','6','.','.','.','.','2','8','.'],
        ['.','.','.','4','1','9','.','.','5'],
        ['.','.','.','.','8','.','.','7','9']
    ]
    
    sol.solveSudoku(board)
    print("Solved Sudoku:")
    for row in board:
        print(''.join(row))
