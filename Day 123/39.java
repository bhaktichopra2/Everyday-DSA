// 39. Combination Sum
// Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

// The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

// The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        findComb(0, target, candidates, res, ds);
        return res;
    }
    
    public void findComb(int ind, int target, int[] arr, List<List<Integer>> ans, List<Integer> ds) {
        // Base case
        if (ind == arr.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        
        // Pick current
        if (arr[ind] <= target) {
            ds.add(arr[ind]);
            findComb(ind, target - arr[ind], arr, ans, ds);  // Same index!
            ds.remove(ds.size() - 1);
        }
        
        // Don't pick - move to next
        findComb(ind + 1, target, arr, ans, ds);
    }
    
    // VSCode Test
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(sol.combinationSum(candidates, target));
    }
}
