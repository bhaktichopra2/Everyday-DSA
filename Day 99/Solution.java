// 18. 4Sum
// Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

// 0 <= a, b, c, d < n
// a, b, c, and d are distinct.
// nums[a] + nums[b] + nums[c] + nums[d] == target
// You may return the answer in any order.

import java.util.*;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        
        for(int i = 0; i < n - 3; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            
            for(int j = i + 1; j < n - 2; j++) {
                if(j > i + 1 && nums[j] == nums[j-1]) continue;
                
                int l = j + 1;
                int r = n - 1;
                
                while(l < r) {
                    long sum = (long)nums[i] + nums[j] + nums[l] + nums[r];
                    
                    if(sum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while(l < r && nums[l] == nums[l+1]) l++;
                        while(l < r && nums[r] == nums[r-1]) r--;
                        l++;
                        r--;
                    } else if(sum < target) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.fourSum(new int[]{2,2,2,2}, 8));           // [[2,2,2,2]]
        System.out.println(sol.fourSum(new int[]{1,0,-1,0,-2,2}, 0));     // [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
    }
}
