// 493. Reverse Pairs (#Solved)
// Given an integer array nums, return the number of reverse pairs in the array.

// A reverse pair is a pair (i, j) where:

// 0 <= i < j < nums.length and
// nums[i] > 2 * nums[j].

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
    
    private static int mergeSort(int[] arr, int low, int high) {
        if (low >= high) return 0;
        
        int mid = low + (high - low) / 2;
        int invCount = mergeSort(arr, low, mid) + 
                      mergeSort(arr, mid + 1, high);
        
        // Count reverse pairs during merge
        invCount += reversePairs(arr, low, mid, high);
        
        // Actual merge
        merge(arr, low, mid, high);
        
        return invCount;
    }
    
    private static void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;
        
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left++]);
            } else {
                temp.add(arr[right++]);
            }
        }
        
        while (left <= mid) temp.add(arr[left++]);
        while (right <= high) temp.add(arr[right++]);
        
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }
    
    public static int reversePairs(int[] arr, int low, int mid, int high) {
        int right = mid + 1;
        int cnt = 0;
        for (int i = low; i <= mid; i++) {
            while (right <= high && (long)arr[i] > 2L * arr[right]) {
                right++;
            }
            cnt += (right - (mid + 1));
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.reversePairs(new int[]{1,3,2,3,1}));  // 2
        System.out.println(sol.reversePairs(new int[]{2,4,3}));      // 0
    }
}
