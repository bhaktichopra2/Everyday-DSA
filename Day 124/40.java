// 40. Combination Sum II
// Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

// Each number in candidates may only be used once in the combination.

// Note: The solution set must not contain duplicate combinations.

import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        findComb(0, target, candidates, ans, ds);
        return ans;
    }
    
    private void findComb(int ind, int target, int[] arr, List<List<Integer>> ans, List<Integer> ds) {
        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        
        for (int i = ind; i < arr.length; i++) {
            // Skip duplicates at same level
            if (i > ind && arr[i] == arr[i - 1]) continue;
            
            // Pruning
            if (arr[i] > target) break;
            
            ds.add(arr[i]);
            findComb(i + 1, target - arr[i], arr, ans, ds);  // i+1 = use once!
            ds.remove(ds.size() - 1);
        }
    }
    
    // VSCode Test
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(sol.combinationSum2(candidates, target));
    }
}
