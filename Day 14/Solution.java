// 78. Subsets
// Given an integer array nums of unique elements, return all possible subsets (the power set).
// The solution set must not contain duplicate subsets. Return the solution in any order
import java.util.*;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int start, List<Integer> currentSubset, List<List<Integer>> result) {
        result.add(new ArrayList<>(currentSubset));
        for (int i = start; i < nums.length; i++) {
            currentSubset.add(nums[i]);
            backtrack(nums, i + 1, currentSubset, result);
            currentSubset.remove(currentSubset.size() - 1);
        }
    }
    
    // Test harness for VS Code
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = sol.subsets(nums);
        System.out.println(result);
        // Output: [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]
    }
}
