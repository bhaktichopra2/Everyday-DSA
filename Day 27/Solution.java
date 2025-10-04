// 496. Next Greater Element I
// The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.

// You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.

// For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.

// Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.

import java.util.Arrays;

public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            arr[i] = -1;
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    for (int k = j + 1; k < nums2.length; k++) {
                        if (nums2[k] > nums2[j]) {
                            arr[i] = nums2[k];
                            break;
                        }
                    }
                    break;
                }
            }
        }
        return arr;
    }

    // Test harness for VS Code
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int[] result = sol.nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(result)); // Output: [-1, 3, -1]
    }
}
