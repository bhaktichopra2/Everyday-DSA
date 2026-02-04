# Find minimum number of coins

# Problem Statement: Given a value V, if we want to make a change for V Rs, and we have an infinite supply of each of the denominations in Indian currency, i.e., we have an infinite supply of { 1, 2, 5, 10, 20, 50, 100, 500, 1000} valued coins/notes, what is the minimum number of coins and/or notes needed to make the change.

# Function to compute minimum number of coins for amount V
def min_coins(V):
    # Coin denominations available
    coins = [1, 2, 5, 10, 20, 50, 100, 500, 1000]
    ans = []
    n = len(coins)

    # Traverse from largest to smallest coin
    for i in range(n - 1, -1, -1):
        # Use coin[i] as many times as possible
        while V >= coins[i]:
            V -= coins[i]
            ans.append(coins[i])
    
    # Return the list of coins used
    return ans

def main():
    # Input amount
    V = 49

    # Get result from function
    ans = min_coins(V)

    # Print output
    print("The value is", V);
    print("The minimum number of coins is", len(ans))
    print("The coins are")
    for coin in ans:
        print(coin, end=" ")

if __name__ == '__main__':
    main()