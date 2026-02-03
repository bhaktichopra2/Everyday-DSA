# Fractional Knapsack Problem : Greedy Approach
# Problem Statement: The weight of N items and their corresponding values are given. We have to put these items in a knapsack of weight W such that the total value obtained is maximized.

# Note: We can either take the item as a whole or break it into smaller units.

def fractional_knapsack(W, items):
    # items = list of [value, weight] pairs
    n = len(items)
    
    # Sort by value/weight ratio (best first)
    items.sort(key=lambda x: x[0]/x[1], reverse=True)
    
    total_value = 0
    current_weight = 0
    
    for value, weight in items:
        if current_weight + weight <= W:
            # Take whole item
            current_weight += weight
            total_value += value
        else:
            # Take fraction
            space_left = W - current_weight
            total_value += (value/weight) * space_left
            break
    
    return total_value

# Test it
items = [[100, 20], [60, 10], [120, 30]]
capacity = 50
print(f"Maximum value: {fractional_knapsack(capacity, items):.2f}")
