# 121. Best Time to Buy and Sell Stock
# You are given an array prices where prices[i] is the price of a given stock on the ith day.

# You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

# Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

from typing import List

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        l, r = 0, 1
        maxPro = 0

        while r != len(prices):
            if prices[l] < prices[r]:
                prof = prices[r] - prices[l]
                maxPro = max(prof, maxPro)
            else:
                l = r
            r += 1
        return maxPro

if __name__ == "__main__":
    # Test case: prices = [7,1,5,3,6,4]
    # Expected: 5 (buy at 1, sell at 6)
    prices = [7, 1, 5, 3, 6, 4]
    
    sol = Solution()
    result = sol.maxProfit(prices)
    
    print(f"Prices: {prices}")
    print(f"Max Profit: {result}")
