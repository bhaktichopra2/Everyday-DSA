// 322. Coin Change
// You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

// Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

// You may assume that you have an infinite number of each kind of coin.
import java.util.Arrays;

class Solution{
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int c : coins) {
                if (i - c >= 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - c]);
                }
            }
        }
        return dp[amount] != amount + 1 ? dp[amount] : -1;
    }

    // Example usage
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] coins1 = {1, 2, 5};
        int amount1 = 11;
        System.out.println(sol.coinChange(coins1, amount1));  // Output: 3 ([5, 5, 1])

        int[] coins2 = {2};
        int amount2 = 3;
        System.out.println(sol.coinChange(coins2, amount2));  // Output: -1 (Impossible)

        int[] coins3 = {1};
        int amount3 = 0;
        System.out.println(sol.coinChange(coins3, amount3));  // Output: 0
    }
}
