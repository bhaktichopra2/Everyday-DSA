# 441. Arranging Coins

# You have n coins and you want to build a staircase with these coins. The staircase consists of k rows where the ith row has exactly i coins. The last row of the staircase may be incomplete.

# Given the integer n, return the number of complete rows of the staircase you will build.

def arrangeCoins(n):
    row = 1

    while n >= row:
        n -= row
        row += 1

    return row - 1


def main():
    n = 8
    result = arrangeCoins(n)

    print("Complete rows:", result)


if __name__ == "__main__":
    main()