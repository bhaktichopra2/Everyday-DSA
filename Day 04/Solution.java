/*
219. Contains Duplicate II
Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

Example 1:
Input: nums = [1,2,3,1], k = 3
Output: true

Example 2:
Input: nums = [1,0,1,1], k = 1
Output: true

Example 3:
Input: nums = [1,2,3,1,2,3], k = 2
Output: false
*/
import java.util.HashSet;
import java.util.Set;

public class Solution{
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                seen.remove(nums[i - k - 1]);
            }
            if (!seen.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        System.out.println(sol.containsNearbyDuplicate(nums, k));  // Output: true

        int[] nums2 = {1,0,1,1};
        int k2 = 1;
        System.out.println(sol.containsNearbyDuplicate(nums2, k2)); // Output: true

        int[] nums3 = {1,2,3,1,2,3};
        int k3 = 2;
        System.out.println(sol.containsNearbyDuplicate(nums3, k3)); // Output: false
    }
}
