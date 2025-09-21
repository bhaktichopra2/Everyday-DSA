// 77. Combinations
// Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].

// You may return the answer in any order.

import java.util.*;

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        bt(1, n, k, new ArrayList<>(), res);
        return res;
    }

    private void bt(int start, int n, int k, List<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= n; i++) {
            path.add(i);
            bt(i + 1, n, k, path, res);
            path.remove(path.size() - 1);
        }
    }

    // Test harness for VS Code
    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 4, k = 2;
        List<List<Integer>> result = sol.combine(n, k);
        System.out.println(result);
        // Output: [[1, 2], [1, 3], [1, 4], [2, 3], [2, 4], [3, 4]]
    }
}
