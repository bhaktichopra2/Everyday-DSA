// 51. N-Queens
// The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

// Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

// Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

import java.util.*;

class Solution {
    public boolean isSafe(int row, int col, char[][] board, int n) {
        // Check left in same row
        for (int j = 0; j < col; j++) {
            if (board[row][j] == 'Q') return false;
        }
        
        // Check upper diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        
        // Check lower diagonal  
        for (int i = row, j = col; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }
    
    public void solve(int col, char[][] board, List<List<String>> ans, int n) {
        // Base case - all queens placed
        if (col == n) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                temp.add(new String(board[i]));
            }
            ans.add(temp);
            return;
        }
        
        // Try placing queen in each row of current column
        for (int row = 0; row < n; row++) {
            if (isSafe(row, col, board, n)) {
                // 🔥 PLACE QUEEN HERE
                board[row][col] = 'Q';
                solve(col + 1, board, ans, n);  // Recurse to next column
                // 🔥 BACKTRACK - remove queen
                board[row][col] = '.';
            }
        }
    }
    
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        
        // Initialize empty board
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        
        solve(0, board, ans, n);
        return ans;
    }
    
    // VSCode Test
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solveNQueens(4));
    }
}
