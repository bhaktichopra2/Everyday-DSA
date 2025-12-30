// 118. Pascal's Triangle
// Given an integer numRows, return the first numRows of Pascal's triangle.

// In Pascal's triangle, each number is the sum of the two numbers directly above it
import java.util.*;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        // Result list to hold all rows
        List<List<Integer>> triangle = new ArrayList<>();

        // Loop for each row
        for (int i = 0; i < numRows; i++) {
            // Create a row with size (i+1), all 1s
            List<Integer> row = new ArrayList<>(Collections.nCopies(i + 1, 1));

            // Fill elements from index 1 to i-1 (middle values)
            for (int j = 1; j < i; j++) {
                // Each element = sum of two elements above it
                row.set(j, triangle.get(i - 1).get(j - 1) +
                           triangle.get(i - 1).get(j));
            }

            // Add current row to the triangle
            triangle.add(row);
        }
        return triangle;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Test with 5 rows
        List<List<Integer>> result = sol.generate(5);
        
        System.out.println("Pascal's Triangle:");
        for (List<Integer> row : result) {
            System.out.println(row);
        }
        // Output:
        // [1]
        // [1, 1]
        // [1, 2, 1]
        // [1, 3, 3, 1]
        // [1, 4, 6, 4, 1]
    }
}
