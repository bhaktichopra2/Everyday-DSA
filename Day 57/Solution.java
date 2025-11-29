// 3512. Minimum Operations to Make Array Sum Divisible by K
// You are given an integer array nums and an integer k. You can perform the following operation any number of times:

// Select an index i and replace nums[i] with nums[i] - 1.
// Return the minimum number of operations required to make the sum of the array divisible by k.
import java.util.Arrays;

public class Solution {
    public int minOperations(int[] nums, int k) {
        int total = Arrays.stream(nums).sum();
        return total % k;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minOperations(new int[]{3,9,7}, 5)); // 4
        System.out.println(s.minOperations(new int[]{1,2,3,4}, 3)); // 1
    }
}
