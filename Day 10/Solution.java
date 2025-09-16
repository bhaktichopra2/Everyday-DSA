// 53. Maximum Subarray
// Given an integer array nums, find the subarray with the largest sum, and return its sum.

class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0; // or throw an exception if that's your convention
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max_so_far = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            if (dp[i] > max_so_far) {
                max_so_far = dp[i];
            }
        }
        return max_so_far;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(sol.maxSubArray(nums1));  // Output: 6

        int[] nums2 = {1};
        System.out.println(sol.maxSubArray(nums2));  // Output: 1

        int[] nums3 = {5,4,-1,7,8};
        System.out.println(sol.maxSubArray(nums3));  // Output: 23
    }
}
