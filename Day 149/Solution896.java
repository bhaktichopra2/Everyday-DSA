// 896. Monotonic Array

// An array is monotonic if it is either monotone increasing or monotone decreasing.

// An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j]. An array nums is monotone decreasing if for all i <= j, nums[i] >= nums[j].

// Given an integer array nums, return true if the given array is monotonic, or false otherwise.

public class Solution896 {

    public boolean isMonotonic(int[] nums) {
        boolean inc = true;
        boolean dec = true;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                dec = false;
            }
            if (nums[i] > nums[i + 1]) {
                inc = false;
            }
        }

        return inc || dec;
    }

    // ---- Test main ----
    public static void main(String[] args) {
        Solution896 sol = new Solution896();
        int[] nums = {1, 2, 2, 3};
        System.out.println(sol.isMonotonic(nums)); // true
    }
}