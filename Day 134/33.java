// 33. Search in Rotated Sorted Array 

// There is an integer array nums sorted in ascending order (with distinct values).

// Prior to being passed to your function, nums is possibly left rotated at an unknown index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be left rotated by 3 indices and become [4,5,6,7,0,1,2].

// Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

// You must write an algorithm with O(log n) runtime complexity.

import java.util.*;

class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (target == nums[mid]) {
                return mid;
            }
            
            // Left half sorted
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            // Right half sorted
            else {
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
    
    // VSCode Test ✅
    public static void main(String[] args) {
        Solution sol = new Solution();
        Object[][] tests = {
            {new int[]{4,5,6,7,0,1,2}, 3},
            {new int[]{1}, 0},
            {new int[]{4,5,6,7,0,1,2}, 0},
            {new int[]{1,3}, 3},
            {new int[]{5,1,3}, 3}
        };
        
        for (Object[] test : tests) {
            int[] nums = (int[]) test[0];
            int target = (int) test[1];
            int result = sol.search(nums, target);
            System.out.printf("nums=%s, target=%d -> index=%d%n", 
                            Arrays.toString(nums), target, result);
        }
    }
}
