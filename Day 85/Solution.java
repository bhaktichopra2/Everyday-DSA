// 73. Set Matrix Zeroes
// Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

// You must do it in place.
class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        boolean[] row = new boolean[n];
        boolean[] col = new boolean[m];

        // Mark rows and columns that contain zero
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        // Set zeros based on marked rows/columns
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        
        System.out.println("Before:");
        for (int[] r : matrix) {
            System.out.println(java.util.Arrays.toString(r));
        }
        
        sol.setZeroes(matrix);
        
        System.out.println("After:");
        for (int[] r : matrix) {
            System.out.println(java.util.Arrays.toString(r));
        }
        // Output: [[1,0,1],[0,0,0],[1,0,1]]
    }
}
