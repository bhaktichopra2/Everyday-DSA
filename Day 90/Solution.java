// 287. Find the Duplicate Number
// Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

// There is only one repeated number in nums, return this repeated number.

// You must solve the problem without modifying the array nums and using only constant extra space.

import java.util.*;

// solution utility using Floyd's Tortoise and Hare
class Solution {
    // find the duplicate using cycle detection
    static int findDuplicate(int[] nums) {
        // initialize pointers at the start
        int slow = nums[0];
        int fast = nums[0];

        // move slow by 1 step and fast by 2 steps until they meet
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // reset fast to start to find the entrance to the cycle
        fast = nums[0];

        // move both by 1 step until they meet at the duplicate
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        // return the duplicate value
        return slow;
    }
        public static void main(String[] args) {
        // initialize input
        int[] arr = new int[]{1, 3, 4, 2, 3};

        // compute and print result
        System.out.println("The duplicate element is " + Solution.findDuplicate(arr));
    }

}


