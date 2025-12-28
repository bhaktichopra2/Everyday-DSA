// 867. Transpose Matrix
// Given a 2D integer array matrix, return the transpose of matrix.

// The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices.
 class Solution {
    public int[][] transpose(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] transpose = new int[col][row];
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }
        return transpose;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Test: 2x3 matrix
        int[][] matrix = {{1,2,3},{4,5,6}};
        int[][] result = sol.transpose(matrix);
        
        System.out.println("Original:");
        for (int[] row : matrix) {
            System.out.println(java.util.Arrays.toString(row));
        }
        System.out.println("Transpose:");
        for (int[] row : result) {
            System.out.println(java.util.Arrays.toString(row));
        }
        // Output: 3x2 matrix [[1,4],[2,5],[3,6]]
    }
}
