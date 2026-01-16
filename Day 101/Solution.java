// 560. Subarray Sum Equals K
// Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

// A subarray is a contiguous non-empty sequence of elements within an array.

import java.util.*;

public class Solution {
    public int subarraySum(int[] nums, int k) {
        int running = 0;
        int total = 0;

        Map<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1);

        for(int i = 0; i < nums.length; i++) {
            running += nums[i];
            int target = running - k;
            if(freq.containsKey(target)) {
                total += freq.get(target);
            }
            freq.put(running, freq.getOrDefault(running, 0) + 1);
        }
        return total;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.subarraySum(new int[]{1,1,1}, 2));              // 2
        System.out.println(sol.subarraySum(new int[]{1,2,3}, 3));              // 2
        System.out.println(sol.subarraySum(new int[]{1,-1,1,1,-2,1,2,-1}, 2)); // 8
    }
}
