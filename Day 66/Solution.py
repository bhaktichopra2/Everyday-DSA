# 122. Best Time to Buy and Sell Stock II
# You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

# On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can sell and buy the stock multiple times on the same day, ensuring you never hold more than one share of the stock.

# Find and return the maximum profit you can achieve.
from typing import List

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        profit = 0
        for i in range(1, len(prices)):
            # Add all positive price differences
            if prices[i] > prices[i - 1]:
                profit += prices[i] - prices[i - 1]
        return profit

if __name__ == "__main__":
    # Test case: prices = [7,1,5,3,6,4]
    # Expected: 7 (1->5: +4, 3->6: +3)
    prices = [7, 1, 5, 3, 6, 4]
    sol = Solution()
    result = sol.maxProfit(prices)
    print(f"Prices: {prices}")
    print(f"Max Profit: {result}")
