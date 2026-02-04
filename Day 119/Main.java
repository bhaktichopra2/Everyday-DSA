// Find minimum number of coins

// Problem Statement: Given a value V, if we want to make a change for V Rs, and we have an infinite supply of each of the denominations in Indian currency, i.e., we have an infinite supply of { 1, 2, 5, 10, 20, 50, 100, 500, 1000} valued coins/notes, what is the minimum number of coins and/or notes needed to make the change.

import java.util.*;

class Solution {
    // Function to get minimum coins for given amount
    public static List<Integer> minCoins(int V) {
        // Available coin denominations
        int[] coins = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
        List<Integer> ans = new ArrayList<>();
        int n = coins.length;

        // Traverse coins from largest to smallest
        for (int i = n - 1; i >= 0; i--) {
            // Use as many coins[i] as possible
            while (V >= coins[i]) {
                V -= coins[i];
                ans.add(coins[i]);
            }
        }

        // Return the list of coins used
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        // Input amount
        int V = 49;

        // Call function from Solution class
        List<Integer> result = Solution.minCoins(V);

        // Output result
        System.out.println("The value is " + V);
        System.out.println("The minimum number of coins is " + result.size());
        System.out.println("The coins are ");
        for (int coin : result) {
            System.out.print(coin + " ");
        }
    }
}