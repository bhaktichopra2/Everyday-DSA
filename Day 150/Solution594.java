// 594. Longest Harmonious Subsequence

// We define a harmonious array as an array where the difference between its maximum value and its minimum value is exactly 1.

// Given an integer array nums, return the length of its longest harmonious subsequence among all its possible subsequences.
import java.util.*;

public class Solution594 {

    public int findLHS(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;

        // Build frequency map
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Check harmonious pairs
        for(int key : map.keySet()){
            if(map.containsKey(key + 1)){
                max = Math.max(max, map.get(key) + map.get(key + 1));
            }
        }

        return max;
    }

    // ---- Main method for VS Code ----
    public static void main(String[] args) {

        Solution594 sol = new Solution594();

        int[] nums = {1,3,2,2,5,2,3,7};

        int result = sol.findLHS(nums);

        System.out.println("Longest Harmonious Subsequence Length: " + result);
    }
}