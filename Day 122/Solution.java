// 90. Subsets II
// Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

// The solution set must not contain duplicate subsets. Return the solution in any order

import java.util.*;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(0, nums, path, result);
        return result;
    }
    
    private void backtrack(int start, int[] nums, List<Integer> path, List<List<Integer>> result) {
        result.add(new ArrayList<>(path));  // Add every subset
        
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;  // Skip dups
            path.add(nums[i]);
            backtrack(i + 1, nums, path, result);
            path.remove(path.size() - 1);
        }
    }
    
    // VSCode Test
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = {1, 2, 2};
        int[] nums2 = {4, 4, 4, 1, 4};
        
        System.out.println("Test 1: " + sol.subsetsWithDup(nums1));
        System.out.println("Test 2: " + sol.subsetsWithDup(nums2));
    }
}
