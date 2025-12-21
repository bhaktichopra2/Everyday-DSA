// 485. Max Consecutive Ones
// Given a binary array nums, return the maximum number of consecutive 1's in the array.
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int curr = 0;
        int best = 0;

        for (int num : nums) {
            if (num == 1) {
                curr++;
                if (curr > best) {
                    best = curr;
                }
            } else {
                curr = 0;
            }
        }
        return best;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 1, 0, 1, 1, 1};
        System.out.println(sol.findMaxConsecutiveOnes(nums)); // 3
    }
}
