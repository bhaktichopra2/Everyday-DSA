// 493. Reverse Pairs (#Attempted)
// Given an integer array nums, return the number of reverse pairs in the array.

// A reverse pair is a pair (i, j) where:

// 0 <= i < j < nums.length and
// nums[i] > 2 * nums[j].


//THIS SOLUTION DOESNT WORK FOR LONG NUMBERS

public class Solution {
    public int reversePairs(int[] nums) {
        int count = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(nums[i] > 2 * nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.reversePairs(new int[]{1,3,2,3,1}));  // 2
        System.out.println(sol.reversePairs(new int[]{2,4,3}));      // 1
    }
}
