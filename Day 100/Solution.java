// 128. Longest Consecutive Sequence
// Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

// You must write an algorithm that runs in O(n) time.

import java.util.*;

public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        int max = 1;

        Set<Integer> set = new HashSet<>();

        // Add all numbers to set
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        // Find longest sequence starting from beginnings
        for(int i : set) {
            if(!set.contains(i - 1)) {
                int x = i;
                int cnt = 1;
                while(set.contains(x + 1)) {
                    x++;
                    cnt++;
                }
                max = Math.max(max, cnt);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.longestConsecutive(new int[]{100,4,200,1,3,2}));      // 4
        System.out.println(sol.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1})); // 9
        System.out.println(sol.longestConsecutive(new int[]{1}));                    // 1
    }
}
