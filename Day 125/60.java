// 60. Permutation Sequence
// The set [1, 2, 3, ..., n] contains a total of n! unique permutations.

// By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

// "123"
// "132"
// "213"
// "231"
// "312"
// "321"
// Given n and k, return the kth permutation sequence.

import java.util.*;

class Solution {
  public String getPermutation(int n, int k) {
    int fact = 1;
    List<Integer> numbers = new ArrayList<>();

    // Calculate (n-1)! and populate numbers 1 to n
    for (int i = 1; i < n; i++) {
      fact *= i;
      numbers.add(i);
    }
    numbers.add(n); // Add n last
    StringBuilder ans = new StringBuilder();
    k--; // Convert to 0-indexed

    while (!numbers.isEmpty()) {
      int idx = k / fact;
      ans.append(numbers.get(idx));
      numbers.remove(idx);

      k = k % fact;
      if (numbers.size() != 0) {
        fact = fact / numbers.size();
      }
    }

    return ans.toString();
  }

  // VSCode Test
  public static void main(String[] args) {
    Solution sol = new Solution();
    System.out.println(sol.getPermutation(3, 3)); // "213"
    System.out.println(sol.getPermutation(4, 9)); // "2314"
  }
}
