// 303. Range Sum Query - Immutable
// Given an integer array nums, handle multiple queries of the following type:

// Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
// Implement the NumArray class:

// NumArray(int[] nums) Initializes the object with the integer array nums.
// int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).


// First Approach
// class NumArray {
//     private int[] nums;

//     public NumArray(int[] nums) {
//         this.nums = nums;
//     }
    
//     public int sumRange(int left, int right) {
//         int sum = 0;
//         for(int i = left; i<=right; i++){
//             sum += this.nums[i];
//         }
//         return sum;
//     }
// }

// /**
//  * Your NumArray object will be instantiated and called as such:
//  * NumArray obj = new NumArray(nums);
//  * int param_1 = obj.sumRange(left,right);
//  */


public class Solution{
    private int[] prefixSum;

    public Solution(int[] nums) {
        this.prefixSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            this.prefixSum[i + 1] = this.prefixSum[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return this.prefixSum[right + 1] - this.prefixSum[left];
    }

    // Test harness for VS Code
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        Solution obj = new Solution(nums);
        System.out.println(obj.sumRange(1, 3)); // sum from index 1 to 3 => 2+3+4 = 9
        System.out.println(obj.sumRange(0, 4)); // sum from index 0 to 4 => 1+2+3+4+5 = 15
    }
}
