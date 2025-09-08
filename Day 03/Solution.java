/*
845. Longest Mountain in Array
You may recall that an array arr is a mountain array if and only if:

arr.length >= 3
There exists some index i (0-indexed) with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
Given an integer array arr, return the length of the longest subarray, which is a mountain. Return 0 if there is no mountain subarray.
*/
public class Solution {
    public int longestMountain(int[] arr) {
        int ret = 0;
        int n = arr.length;
        for (int i = 1; i < n - 1; i++) {
            if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
                int l = i, r = i;
                while (l > 0 && arr[l] > arr[l - 1]) {
                    l--;
                }
                while (r < n - 1 && arr[r] > arr[r + 1]) {
                    r++;
                }
                ret = Math.max(ret, r - l + 1);
            }
        }
        return ret;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {2,1,4,7,3,2,5};
        System.out.println(sol.longestMountain(arr)); // Output: 5
    }
}
