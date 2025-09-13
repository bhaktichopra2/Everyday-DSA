// 136. Single Number

// Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

// You must implement a solution with a linear runtime complexity and use only constant extra space.

//First Approach
// class Solution {
//     public int singleNumber(int[] nums) {
//         Arrays.sort(nums);
//         int res=0;

//         for(int i=0; i<nums.length-1; i++){
//             if(nums[i]==nums[i+1]){
//                 i++;
//             }
//             else{
//                 return nums[i];
//             }
//         }
//         return nums[nums.length-1];
//     }
// }

class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num; // XOR accumulates unique number
        }
        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(sol.singleNumber(nums));  // Output: 4
    }
}
