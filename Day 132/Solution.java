// Median of Row Wise Sorted Matrix

// Problem Statement:
// Given a row-wise sorted matrix of size M*N, where M is no. of rows and N is no. of columns, find the median in the given matrix.
// Note: M*N is odd.

class Solution {
  // Function to count elements less than or equal to mid in a row
  int countLessEqual(int[] row, int mid) {
    int low = 0, high = row.length;
    while (low < high) {
      int m = (low + high) / 2;
      if (row[m] <= mid)
        low = m + 1;
      else
        high = m;
    }
    return low;
  }

  // Function to find the median
  int findMedian(int[][] matrix) {
    int row = matrix.length;
    int cols = matrix[0].length;

    int low = matrix[0][0];
    int high = matrix[0][cols - 1];
    for (int i = 1; i < row; i++) {
      low = Math.min(low, matrix[i][0]);
      high = Math.max(high, matrix[i][cols - 1]);
    }

    while (low < high) {
      int mid = (low + high) / 2;
      int count = 0;

      for (int i = 0; i < row; i++) {
        count += countLessEqual(matrix[i], mid);
      }

      if (count < (row * cols + 1) / 2)
        low = mid + 1;
      else
        high = mid;
    }
    return low;
  }

  public static void main(String[] args) {
    Solution obj = new Solution();
    int[][] matrix = {
        { 1, 3, 5 },
        { 2, 6, 9 },
        { 3, 6, 9 }
    };
    System.out.println("Median: " + obj.findMedian(matrix));
  }
}
