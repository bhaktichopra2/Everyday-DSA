// 540. Single Element in a Sorted Array

// You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

// Return the single element that appears only once.

// Your solution must run in O(log n) time and O(1) space.

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        
        // Edge cases
        if (n == 1) return nums[0];
        if (nums[0] != nums[1]) return nums[0];
        if (nums[n-1] != nums[n-2]) return nums[n-1];
        
        int l = 1, h = n - 2;
        while (l <= h) {
            int mid = l + (h - l) / 2;  // ✅ Overflow safe
            
            // Found single element
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }
            
            // ✅ FIXED Logic: Move to correct half
            if ((mid % 2 == 0 && nums[mid] == nums[mid + 1]) || 
                (mid % 2 == 1 && nums[mid] == nums[mid - 1])) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return -1;
    }
    
    // VSCode Test
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] tests = {
            {1,1,2,3,3,4,4,8,8},  // 2
            {3,3,7,7,10,11,11},   // 10
            {1,1,2},               // 2
            {1}                    // 1
        };
        
        for (int[] test : tests) {
            System.out.println("Input: " + java.util.Arrays.toString(test) + 
                             " → Single: " + sol.singleNonDuplicate(test));
        }
    }
}
