// 35. Search Insert Position
// Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

// You must write an algorithm with O(log n) runtime complexity.
public class Solution {
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.searchInsert(new int[]{1,3,5,6}, 5)); // 2
        System.out.println(s.searchInsert(new int[]{1,3,5,6}, 2)); // 1
        System.out.println(s.searchInsert(new int[]{1,3,5,6}, 7)); // 4
        System.out.println(s.searchInsert(new int[]{1,3,5,6}, 0)); // 0
    }
}
