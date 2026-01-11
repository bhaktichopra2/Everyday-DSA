// 2965. Find Missing and Repeated Values
// You are given a 0-indexed 2D integer matrix grid of size n * n with values in the range [1, n2]. Each integer appears exactly once except a which appears twice and b which is missing. The task is to find the repeating and missing numbers a and b.

// Return a 0-indexed integer array ans of size 2 where ans[0] equals to a and ans[1] equals to b.

import java.util.Arrays;

public class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int total = n * n;
        int[] count = new int[total + 1];
        
        // Count frequency of each number (1 to n²)
        for(int[] row : grid) {
            for(int num : row) {
                count[num]++;
            }
        }
        
        int rep = -1, mis = -1;
        // Find repeated (count=2) and missing (count=0)
        for(int i = 1; i <= total; i++) {
            if(count[i] == 2) rep = i;
            else if(count[i] == 0) mis = i;
        }
        
        return new int[]{rep, mis};
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] grid1 = {{1,3},{2,2}};
        System.out.println(Arrays.toString(sol.findMissingAndRepeatedValues(grid1))); // [2,4]
        
        int[][] grid2 = {{1,1},{2,3}};
        System.out.println(Arrays.toString(sol.findMissingAndRepeatedValues(grid2))); // [1,4]
    }
}
