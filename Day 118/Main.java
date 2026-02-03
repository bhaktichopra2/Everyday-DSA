// Fractional Knapsack Problem : Greedy Approach
// Problem Statement: The weight of N items and their corresponding values are given. We have to put these items in a knapsack of weight W such that the total value obtained is maximized.

// Note: We can either take the item as a whole or break it into smaller units.

import java.util.*;

class Solution {
    
    public double fractionalKnapsack(int W, Item[] items, int n) {
        // Validate inputs
        if (W <= 0 || items == null || n == 0) return 0.0;
        
        // Sort by value/weight ratio (DESCENDING) - ONE LINE using lambda!
        Arrays.sort(items, 0, n, Comparator.comparingDouble(
            item -> -(double)item.value / item.weight  // Negative for descending
        ));
        
        double totalValue = 0;
        int currentWeight = 0;
        
        // Greedy filling
        for (int i = 0; i < n; i++) {
            if (items[i].weight == 0) continue;  // Skip invalid items
            
            if (currentWeight + items[i].weight <= W) {
                // Take whole item
                currentWeight += items[i].weight;
                totalValue += items[i].value;
            } else {
                // Take fraction
                int spaceLeft = W - currentWeight;
                totalValue += (double)items[i].value / items[i].weight * spaceLeft;
                break;
            }
        }
        
        return totalValue;
    }
    
    static class Item {
        int value, weight;
        Item(int v, int w) { value = v; weight = w; }
    }
}

public class Main {
    public static void main(String[] args) {
        int capacity = 50;
        Solution.Item[] items = {
            new Solution.Item(100, 20),
            new Solution.Item(60, 10), 
            new Solution.Item(120, 30)
        };
        
        System.out.printf("Maximum value: %.2f%n", 
            new Solution().fractionalKnapsack(capacity, items, 3));
    }
}
