// 51. N-Queens
// The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

// Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

// Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

import java.util.*;

class Solution {
    public void solve(int col, char[][] board, int n,
                     int[] leftRow, int[] upperDiagonal, int[] lowerDiagonal,
                     List<List<String>> res) {
        // Base case - all queens placed
        if (col == n) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                temp.add(new String(board[i]));
            }
            res.add(temp);
            return;
        }
        
        // Try each row
        for (int row = 0; row < n; row++) {
            // Check if safe using 3 arrays
            if (leftRow[row] == 0 && 
                lowerDiagonal[row + col] == 0 && 
                upperDiagonal[n - 1 + col - row] == 0) {
                
                // Place queen + mark
                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[n - 1 + col - row] = 1;
                
                solve(col + 1, board, n, leftRow, upperDiagonal, lowerDiagonal, res);
                
                // Backtrack
                board[row][col] = '.';
                leftRow[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[n - 1 + col - row] = 0;
            }
        }
    }
    
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        
        // Initialize board
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        
        // 3 tracking arrays O(N)
        int[] leftRow = new int[n];           // Row occupancy
        int[] lowerDiagonal = new int[2 * n - 1];  // Lower diagonal
        int[] upperDiagonal = new int[2 * n - 1];  // Upper diagonal
        
        solve(0, board, n, leftRow, upperDiagonal, lowerDiagonal, res);
        return res;
    }
    
    // VSCode Test
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("N=4 solutions:");
        List<List<String>> result = sol.solveNQueens(4);
        for (List<String> board : result) {
            System.out.println(board);
        }
    }
}
