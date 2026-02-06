// Subset Sum : Sum of all Subsets

// Problem Statement: Given an array print all the sum of the subset generated from it, in the increasing order.

import java.util.*;

class Solution {
    // Helper function to recursively find subset sums
    public void findSums(int index, int currentSum, int[] arr, List<Integer> sums) {
        if (index == arr.length) {
            sums.add(currentSum);
            return;
        }

        // Include current element
        findSums(index + 1, currentSum + arr[index], arr, sums);

        // Exclude current element
        findSums(index + 1, currentSum, arr, sums);
    }

    public List<Integer> subsetSums(int[] arr) {
        List<Integer> sums = new ArrayList<>();
        findSums(0, 0, arr, sums);
        Collections.sort(sums);
        return sums;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = { 5, 2, 1 };
        List<Integer> result = sol.subsetSums(arr);

        for (int sum : result) {
            System.out.print(sum + " ");
        }
        System.out.println();
    }

}
