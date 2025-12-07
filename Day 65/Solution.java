// 121. Best Time to Buy and Sell Stock
// You are given an array prices where prices[i] is the price of a given stock on the ith day.

// You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

// Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
import java.util.Arrays;

class Solution {
    public int maxProfit(int[] prices) {
        int left = 0;
        int right = 1;
        int max = 0;

        while (right < prices.length) {
            if (prices[left] <= prices[right]) {
                int profit = prices[right] - prices[left];
                max = Math.max(max, profit);
            } else {
                left = right;
            }
            right++;
        }
        return max;
    }
    
    public static void main(String[] args) {
        // Test case: prices = [7,1,5,3,6,4]
        // Expected: 5 (buy at 1, sell at 6)
        int[] prices = {7, 1, 5, 3, 6, 4};
        
        Solution sol = new Solution();
        int result = sol.maxProfit(prices);
        
        System.out.println("Prices: " + Arrays.toString(prices));
        System.out.println("Max Profit: " + result);
    }
}
