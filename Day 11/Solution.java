// 338. Counting Bits
// Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.

 import java.util.Arrays;

public class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        int offset = 1;

        for (int i = 1; i < n + 1; i++) {
            if (offset * 2 == i) {
                offset = i;
            }
            dp[i] = 1 + dp[i - offset];
        }
        return dp;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 5;  // You can change the input value here
        int[] result = sol.countBits(n);
        System.out.println(Arrays.toString(result));
    }
}
