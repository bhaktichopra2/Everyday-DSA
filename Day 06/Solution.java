// 209. Minimum Size Subarray Sum

// Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int l = 0;
        int sum = 0;

        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];
            while (sum >= target) {
                res = Math.min(res, r - l + 1);
                sum -= nums[l];
                l++;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr1 = {2,3,1,2,4,3};
        int target1 = 7;
        System.out.println(sol.minSubArrayLen(target1, arr1)); // Output: 2

        int[] arr2 = {1,4,4};
        int target2 = 4;
        System.out.println(sol.minSubArrayLen(target2, arr2)); // Output: 1

        int[] arr3 = {1,1,1,1,1,1,1,1};
        int target3 = 11;
        System.out.println(sol.minSubArrayLen(target3, arr3)); // Output: 0
    }
}
